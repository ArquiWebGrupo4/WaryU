package com.example.waryu.Controllers;

import com.example.waryu.Dtos.IncidenteDTO;
import com.example.waryu.Dtos.UsuarioDTO;
import com.example.waryu.Entities.Incidente;
import com.example.waryu.Entities.Usuario;
import com.example.waryu.ServiceInterfaces.IncidenteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Incidente")
public class IncidenteController {
    @Autowired
    private IncidenteService iS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<IncidenteDTO> lista = iS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, IncidenteDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen incidentes registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody IncidenteDTO dto) {
        ModelMapper m = new ModelMapper();
        Incidente d = m.map(dto, Incidente.class);
        iS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Incidente registrado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Incidente incidente = iS.findID(id);
        if (incidente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un incidente con el ID: " + id);
        }
        iS.delete(id);
        return ResponseEntity.ok("Incidente con ID " + id + " eliminado correctamente.");
    }
}
