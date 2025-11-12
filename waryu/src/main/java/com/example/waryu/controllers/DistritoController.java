package com.example.waryu.controllers;

import com.example.waryu.dtos.DistritoDTO;
import com.example.waryu.dtos.DistritoPeligrosoDTO;
import com.example.waryu.entities.Distrito;
import com.example.waryu.serviceinterfaces.IDistritoService;
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
@RequestMapping("/Distrito")
public class DistritoController {
    @Autowired
    private IDistritoService dS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<DistritoDTO> lista = dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DistritoDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen distritos registrados.");
        }
        return ResponseEntity.ok(lista);
    }
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody DistritoDTO dto) {
        ModelMapper m = new ModelMapper();
        Distrito d = m.map(dto, Distrito.class);
        dS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Distrito registrado correctamente.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Distrito np = dS.listId(id);
        if (np == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un distrito con el ID: " + id);
        }
        dS.delete(id);
        return ResponseEntity.ok("Distrito con ID " + id + " eliminado");
    }
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody DistritoDTO dto) {
        ModelMapper m = new ModelMapper();
        Distrito d = m.map(dto, Distrito.class);
        Distrito existe =dS.listId(d.getID_Distrito());
        if(existe == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID " + d.getID_Distrito());
        }
        dS.update(d);
        return ResponseEntity.ok("Distrito modificado correctamente.");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findID(@PathVariable("id") Integer id) {
        Distrito d = dS.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        DistritoDTO dto = m.map(d, DistritoDTO.class);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/Distritos-con-incidentes-peligrosos")
    public ResponseEntity<?> getIncidentesPeligrososPorDistrito() {
        List<Object[]> results = dS.DistritoPeligroso();
        List<DistritoPeligrosoDTO> listaDto = new ArrayList<>();

        if (results == null || results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body("No hay incidentes peligrosos registrados.");
        }

        for (Object[] result : results) {
            DistritoPeligrosoDTO dto = new DistritoPeligrosoDTO();
            dto.setDistrito((String) result[0]);
            dto.setNivelPeligro(((Number) result[1]).intValue());
            dto.setTotal(((Number) result[2]).longValue());
            listaDto.add(dto);
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listaDto);
    }
}
