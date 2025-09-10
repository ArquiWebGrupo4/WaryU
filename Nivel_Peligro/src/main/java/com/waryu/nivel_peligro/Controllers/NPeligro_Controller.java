package com.waryu.nivel_peligro.Controllers;

import com.waryu.nivel_peligro.dtos.NPeligroDTO;
import com.waryu.nivel_peligro.entities.Nivel_Peligro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.waryu.nivel_peligro.serviceinterfaces.INPeligroService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Nivel_Peligro")
public class NPeligro_Controller {
    @Autowired
    private INPeligroService nPS;

    @GetMapping
    public List<NPeligroDTO> list() {
        return nPS.list().stream().map(nivelPeligro -> {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(nivelPeligro, NPeligroDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insert(@RequestBody NPeligroDTO dto) {
        ModelMapper mapper = new ModelMapper();
        Nivel_Peligro np = mapper.map(dto, Nivel_Peligro.class);
        nPS.insert(np);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Nivel_Peligro np = nPS.listId(id);
        if (np == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID: " + id);
        }
        nPS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado");
    }
}

