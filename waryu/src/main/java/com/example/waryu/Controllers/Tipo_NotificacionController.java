package com.example.waryu.Controllers;

import com.example.waryu.Dtos.Tipo_NotificacionDTO;
import com.example.waryu.Entities.Distrito;
import com.example.waryu.Entities.Tipo_Notificacion;
import com.example.waryu.ServiceInterfaces.ITipo_NotificacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Tipo_Notificacion")
public class Tipo_NotificacionController {
    @Autowired
    private ITipo_NotificacionService tpN;
    @GetMapping
    @PreAuthorize("hasAuthority('usuario')")
    public ResponseEntity<?> listar() {
        List<Tipo_NotificacionDTO> list = tpN.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Tipo_NotificacionDTO.class);
        }).collect(Collectors.toList());

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen tipos de notificaciones registrados.");
        }
        return ResponseEntity.ok(list);
    }
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody Tipo_NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Tipo_Notificacion d = m.map(dto, Tipo_Notificacion.class);
        tpN.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tipo de notificacion registrado correctamente.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Tipo_Notificacion np = tpN.listId(id);
        if(np == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registro de tipos de notificacion con ID: "+ id);
        }
        tpN.delete(id);
        return ResponseEntity.ok("Tipo de notificacion con ID " + id + " eliminado");
    }
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody Tipo_NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Tipo_Notificacion d = m.map(dto, Tipo_Notificacion.class);
        Tipo_Notificacion existe =tpN.listId(d.getId_Tipo_Notificacion());
        if(existe == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID " + d.getId_Tipo_Notificacion());
        }
        tpN.update(d);
        return ResponseEntity.ok("Tipo de notificacion modificado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findID(@PathVariable("id") Integer id) {
        Tipo_Notificacion tn = tpN.listId(id);
        if (tn == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        Tipo_NotificacionDTO dto = m.map(tn, Tipo_NotificacionDTO.class);
        return ResponseEntity.ok(dto);
    }
}
