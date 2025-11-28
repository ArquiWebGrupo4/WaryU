package com.example.waryu.controllers;

import com.example.waryu.dtos.Boton_PanicoDTO;
import com.example.waryu.dtos.Boton_PanicoSecDTO;
import com.example.waryu.entities.Boton_Panico;
import com.example.waryu.entities.Usuario;
import com.example.waryu.serviceinterfaces.IBoton_PanicoService;
import com.example.waryu.serviceinterfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/botonpanico")
public class Boton_PanicoController {
    @Autowired
    private IBoton_PanicoService btn_pan;
    @Autowired
    private IUsuarioService uS;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<?> listarBoton_Panico()
    {
        List<Boton_PanicoSecDTO> lista = btn_pan.list().stream().map(x->{
            ModelMapper mapper = new ModelMapper();
            Boton_PanicoSecDTO dto = mapper.map(x, Boton_PanicoSecDTO.class);
            dto.getUsuario().setNombreUsuario(x.getUsuario().getNombreusuario());
            return dto;
        }).collect(Collectors.toList());
        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("No existen registros de boton de panico accionados");
        }
        return ResponseEntity.ok(lista);
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<String> registrar(@RequestBody Boton_PanicoDTO dto){
        ModelMapper mapper = new ModelMapper();
        Boton_Panico d = mapper.map(dto, Boton_Panico.class);
        btn_pan.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED).body("Boton de panico accionado registrado");
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Boton_Panico d = btn_pan.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        btn_pan.delete(id);
        return ResponseEntity.ok("Busqueda con ID " + id + " eliminado");
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody Boton_PanicoDTO dto) {
        ModelMapper m = new ModelMapper();
        Boton_Panico b = m.map(dto, Boton_Panico.class);
        Boton_Panico existe =btn_pan.listId(b.getID_Boton_Panico());
        if(existe == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID " + b.getID_Boton_Panico());
        }
        btn_pan.update(b);
        return ResponseEntity.ok("Boton de panico modificado correctamente.");
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<?> findID(@PathVariable("id") Integer id) {
        Boton_Panico d = btn_pan.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        Boton_PanicoSecDTO dto = m.map(d, Boton_PanicoSecDTO.class);
        return ResponseEntity.ok(dto);
    }
    @PostMapping("/interact")
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<?> enviarAlerta(
            @RequestParam String nombreusuario) {
        try {

            double[] coords = {java.util.concurrent.ThreadLocalRandom.current().nextDouble(-90.0, 90.0), java.util.concurrent.ThreadLocalRandom.current().nextDouble(-180.0, 180.0)};
            Usuario U = uS.findOneByUsuario(nombreusuario);
            int id = U.getID_Usuario();
            String idUsuario = String.valueOf(id);
            if(U == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con ID: " + idUsuario);
            }
            Boton_Panico b = new Boton_Panico();
            b.setID_Boton_Panico(0);
            b.setUsuario(U);
            b.setFecha_Activacion(LocalDateTime.now());
            b.setLat(coords[0]);
            b.setLon(coords[1]);
            btn_pan.insert(b);
            btn_pan.interact(idUsuario, coords[0], coords[1]);
            return ResponseEntity.ok("Mensaje enviado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al enviar el mensaje: " + e.getMessage());
        }
    }
    @PostMapping("/test")
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<?> testHelloWorld() {
        try {
            btn_pan.test();
            return ResponseEntity.ok("Mensaje hello_world enviado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al enviar el mensaje: " + e.getMessage());
        }
    }

}
