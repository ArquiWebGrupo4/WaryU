package com.example.waryu.Controllers;

import com.example.waryu.Dtos.*;
import com.example.waryu.Entities.*;
import com.example.waryu.Repositories.IRolRepository;
import com.example.waryu.Repositories.IUsuarioRepository;
import com.example.waryu.ServiceInterfaces.BusquedaService;
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
@RequestMapping("/Busqueda")
public class BusquedaController {
    @Autowired
    private BusquedaService bS;

    @GetMapping
    @PreAuthorize("hasAuthority('usuario')")
    public ResponseEntity<?> listar() {
        List<BusquedaSecDTO> lista = bS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, BusquedaSecDTO.class);
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
    @PutMapping
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
    public ResponseEntity<?> findID(@PathVariable("id") Integer id) {
        Busqueda b = bS.listId(id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        BusquedaDTO dto = m.map(b, BusquedaDTO.class);
        return ResponseEntity.ok(dto);
    }
}
