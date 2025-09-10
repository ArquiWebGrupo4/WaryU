package com.example.waryu.Controllers;

import com.example.waryu.Dtos.Tipo_IncidenteDTO;
import com.example.waryu.Entities.Tipo_Incidente;
import com.example.waryu.ServiceInterfaces.ITipo_IncidenteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Tipo_Incidente")
public class Tipo_IncidenteController {
    @Autowired
    private ITipo_IncidenteService nTI;
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Tipo_IncidenteDTO> list = nTI.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Tipo_IncidenteDTO.class);
        }).collect(Collectors.toList());

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen dispositivos registrados.");
        }
        return ResponseEntity.ok(list);
    }
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody Tipo_IncidenteDTO dto) {
        ModelMapper m = new ModelMapper();
        Tipo_Incidente d = m.map(dto, Tipo_Incidente.class);
        nTI.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Dispositivo registrado correctamente.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Tipo_Incidente np = nTI.listId(id);
        if(np == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registro de incidentes con ID: "+ id);
        }
        nTI.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + "eliminado");
    }
}
