package com.example.waryu.Controllers;

import com.example.waryu.Dtos.NotificacionDTO;
import com.example.waryu.Dtos.UsuarioDTO;
import com.example.waryu.Entities.Distrito;
import com.example.waryu.Entities.Notificacion;
import com.example.waryu.Entities.Usuario;
import com.example.waryu.ServiceInterfaces.INotificacionService;
import org.aspectj.weaver.ast.Not;
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
@RequestMapping("/Notificacion")
public class NotificacionController {
    @Autowired
    private INotificacionService nS;

    @GetMapping
    @PreAuthorize("hasAuthority('usuario')")
    public ResponseEntity<?> list() {
        List<NotificacionDTO> lista = nS.List().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen usuarios registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto, Notificacion.class);
        nS.Insert(n);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Notificacion registrada correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Notificacion notificacion = nS.ListarId(id);
        if (notificacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        nS.Delete(id);
        return ResponseEntity.ok("Notificacion con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto, Notificacion.class);
        Notificacion existe =nS.ListarId(n.getID_Notificacion());
        if(existe == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID " + n.getID_Notificacion());
        }
        nS.update(n);
        return ResponseEntity.ok("Notificacion modificada correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findID(@PathVariable("id") Integer id) {
        Notificacion n = nS.ListarId(id);
        if (n == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        NotificacionDTO dto = m.map(n, NotificacionDTO.class);
        return ResponseEntity.ok(dto);
    }
}
