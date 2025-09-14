package com.example.waryu.Controllers;

import com.example.waryu.Dtos.Nivel_PeligroDTO;
import com.example.waryu.Entities.Nivel_Peligro;
import com.example.waryu.ServiceInterfaces.INivel_PeligroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Nivel_Peligro")
public class Nivel_PeligroController {
    @Autowired
    private INivel_PeligroService nPS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Nivel_PeligroDTO> lista = nPS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Nivel_PeligroDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen niveles de peligro registrados.");
        }
        return ResponseEntity.ok(lista);
    }
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody Nivel_PeligroDTO dto) {
        ModelMapper m = new ModelMapper();
        Nivel_Peligro d = m.map(dto, Nivel_Peligro.class);
        nPS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Nivel de peligro registrado correctamente.");
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