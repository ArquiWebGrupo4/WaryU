package com.example.waryu.controllers;

import com.example.waryu.dtos.*;
import com.example.waryu.entities.*;
import com.example.waryu.serviceinterfaces.BusquedaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Busqueda")
public class BusquedaController {
    @Autowired
    private BusquedaService bS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<?> listar() {
        List<BusquedaSecDTO> lista = bS.list().stream().map(x -> {
            ModelMapper mapper = new ModelMapper();
            BusquedaSecDTO dto = mapper.map(x, BusquedaSecDTO.class);
            dto.getUsuario().setNombreUsuario(x.getUsuario().getNombreusuario());
            return dto;
        }).collect(Collectors.toList());
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen busquedas registrados");
        }
        return ResponseEntity.ok(lista);
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<String> registrar(@RequestBody BusquedaDTO dto) {
        ModelMapper m = new ModelMapper();
        Busqueda d = m.map(dto, Busqueda.class);
        bS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Busqueda ingresada corractamente");
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Busqueda np = bS.listId(id);
        if (np == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe una busqueda con el ID: " + id);
        }
        bS.delete(id);
        return ResponseEntity.ok("Busqueda con ID " + id + " eliminado");
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody BusquedaDTO dto) {
        ModelMapper m = new ModelMapper();
        Busqueda d = m.map(dto, Busqueda.class);
        Busqueda existe =bS.listId(d.getID_Busqueda());
        if(existe == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID " + d.getID_Busqueda());
        }
        bS.update(d);
        return ResponseEntity.ok("Busqueda modificado correctamente.");
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
    public ResponseEntity<?> findID(@PathVariable("id") Integer id) {
        Busqueda b = bS.listId(id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        BusquedaSecDTO dto = m.map(b, BusquedaSecDTO.class);
        return ResponseEntity.ok(dto);
    }
}
