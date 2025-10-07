package com.example.waryu.controllers;

import com.example.waryu.dtos.UsoBotonUsuariosDTO;
import com.example.waryu.dtos.UsuarioDTO;
import com.example.waryu.dtos.UsuarioSecDTO;
import com.example.waryu.entities.Usuario;
import com.example.waryu.serviceinterfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;
    @Autowired
    private IUsuarioService iUsuarioService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<?> listar() {
        List<UsuarioSecDTO> lista = uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioSecDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen usuarios registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<String> registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario d = m.map(dto, Usuario.class);
        uS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Dispositivo registrado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Usuario usuario = uS.findID(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        uS.delete(id);
        return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        Usuario existe =uS.findID(u.getID_Usuario());
        if(existe == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID " + u.getID_Usuario());
        }
        uS.update(u);
        return ResponseEntity.ok("Usuario modificado correctamente.");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<?> findID(@PathVariable("id") Integer id) {
        Usuario u = uS.findID(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioSecDTO dto = m.map(u, UsuarioSecDTO.class);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/uso-boton-de-panico-por-usuario")
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<?> usoBotonDePanicoPorUsuario() {
        List<UsoBotonUsuariosDTO> listaDTO = new ArrayList<>();
        List<String[]> fila = uS.UsoBotonPanicoPorUsuario();
        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN)
                    .body("No hay usuarios con activaciones del boton de panico");
        }
        for (String[] x : fila) {
            UsoBotonUsuariosDTO dto = new UsoBotonUsuariosDTO();
            dto.setNombre(x[0]);
            dto.setUsosTotales(Integer.parseInt(x[1]));
            listaDTO.add(dto);
        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(listaDTO);
    }
}
