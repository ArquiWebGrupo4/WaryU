package com.example.waryu.Controllers;

import com.example.waryu.Dtos.IncidenteDTO;
import com.example.waryu.Dtos.IncidenteSecDTO;
import com.example.waryu.Dtos.UsuarioDTO;
import com.example.waryu.Entities.Distrito;
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
        List<IncidenteSecDTO> lista = iS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, IncidenteSecDTO.class);
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

    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody IncidenteDTO dto) {
        ModelMapper m = new ModelMapper();
        Incidente i = m.map(dto, Incidente.class);
        Incidente existe =iS.findID(i.getID_Incidente());
        if(existe == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID " + i.getID_Incidente());
        }
        iS.update(i);
        return ResponseEntity.ok("Incidente modificado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findID(@PathVariable("id") Integer id) {
        Incidente i = iS.findID(id);
        if (i == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        IncidenteDTO dto = m.map(i, IncidenteDTO.class);
        return ResponseEntity.ok(dto);
    }
}
