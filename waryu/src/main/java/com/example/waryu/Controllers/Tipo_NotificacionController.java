package com.example.waryu.Controllers;

import com.example.waryu.Dtos.Tipo_NotificacionDTO;
import com.example.waryu.Entities.Tipo_Notificacion;
import com.example.waryu.ServiceInterfaces.ITipo_NotificacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Tipo_Notificacion")
public class Tipo_NotificacionController {
    @Autowired
    private ITipo_NotificacionService tpN;
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Tipo_NotificacionDTO> list = tpN.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Tipo_NotificacionDTO.class);
        }).collect(Collectors.toList());

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen dispositivos registrados.");
        }
        return ResponseEntity.ok(list);
    }
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody Tipo_NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Tipo_Notificacion d = m.map(dto, Tipo_Notificacion.class);
        tpN.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tipo de incidente registrado correctamente.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Tipo_Notificacion np = tpN.listId(id);
        if(np == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registro de tipos de incidentes con ID: "+ id);
        }
        tpN.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado");
    }
}
