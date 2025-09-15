package com.example.waryu.Controllers;

import com.example.waryu.Dtos.BusquedaDTO;
import com.example.waryu.Dtos.DistritoDTO;
import com.example.waryu.Entities.Busqueda;
import com.example.waryu.Entities.Distrito;
import com.example.waryu.ServiceInterfaces.BusquedaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Busqueda")
public class BusquedaController {
    @Autowired
    private BusquedaService bS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<BusquedaDTO> lista = bS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, BusquedaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen busquedas registrados");
        }
        return ResponseEntity.ok(lista);
    }
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody BusquedaDTO dto) {
        ModelMapper m = new ModelMapper();
        Busqueda d = m.map(dto, Busqueda.class);
        bS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Busqueda ingresada corractamente");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Busqueda np = bS.listId(id);
        if (np == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe una busqueda con el ID: " + id);
        }
        bS.delete(id);
        return ResponseEntity.ok("Busqueda con ID " + id + " eliminado");
    }
}
