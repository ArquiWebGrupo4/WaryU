package com.example.waryu.Controllers;

import com.example.waryu.Dtos.Tipo_IncidenteDTO;
import com.example.waryu.Dtos.Tipo_NotificacionDTO;
import com.example.waryu.Entities.Distrito;
import com.example.waryu.Entities.Tipo_Incidente;
import com.example.waryu.Entities.Tipo_Notificacion;
import com.example.waryu.ServiceInterfaces.ITipo_IncidenteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Tipo_Incidente")
public class Tipo_IncidenteController {
    @Autowired
    private ITipo_IncidenteService nTI;
    @GetMapping
    @PreAuthorize("hasAuthority('usuario')")
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
                .body("Tipo de incidente registrado correctamente.");
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
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody Tipo_IncidenteDTO dto) {
        ModelMapper m = new ModelMapper();
        Tipo_Incidente d = m.map(dto, Tipo_Incidente.class);
        Tipo_Incidente existe =nTI.listId(d.getId_Tipo_Incidente());
        if(existe == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID " + d.getId_Tipo_Incidente());
        }
        nTI.update(d);
        return ResponseEntity.ok("Tipo de incidente modificado  correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findID(@PathVariable("id") Integer id) {
        Tipo_Incidente ti = nTI.listId(id);
        if (ti == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        Tipo_IncidenteDTO  dto = m.map(ti, Tipo_IncidenteDTO.class);
        return ResponseEntity.ok(dto);
    }
}
