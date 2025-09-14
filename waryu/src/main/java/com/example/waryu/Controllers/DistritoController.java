package com.example.waryu.Controllers;

import com.example.waryu.Dtos.DistritoDTO;
import com.example.waryu.Dtos.Nivel_PeligroDTO;
import com.example.waryu.Entities.Distrito;
import com.example.waryu.Entities.Nivel_Peligro;
import com.example.waryu.ServiceInterfaces.IDistritoService;
import com.example.waryu.ServiceInterfaces.INivel_PeligroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                    .body("No existen niveles de peligro registrados.");
        }
        return ResponseEntity.ok(lista);
    }
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody DistritoDTO dto) {
        ModelMapper m = new ModelMapper();
        Distrito d = m.map(dto, Distrito.class);
        dS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Nivel de peligro registrado correctamente.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Distrito np = dS.listId(id);
        if (np == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un registro con el ID: " + id);
        }
        dS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado");
    }
}
