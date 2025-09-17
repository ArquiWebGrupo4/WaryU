package com.example.waryu.Controllers;

import com.example.waryu.Dtos.UsuarioDTO;
import com.example.waryu.Dtos.UsuarioSecDTO;
import com.example.waryu.Entities.Usuario;
import com.example.waryu.ServiceImplements.UsuarioServiceImplement;
import com.example.waryu.ServiceInterfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;

    @GetMapping
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
    public ResponseEntity<String> registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario d = m.map(dto, Usuario.class);
        uS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Dispositivo registrado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Usuario usuario = uS.findID(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        uS.delete(id);
        return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente.");
    }
}
