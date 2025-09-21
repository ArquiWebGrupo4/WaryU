package com.example.waryu.Controllers;

import com.example.waryu.Dtos.DistritoDTO;
import com.example.waryu.Dtos.DistritoFavoritoDTO;
import com.example.waryu.Dtos.DistritoFavoritoSecDTO;
import com.example.waryu.Dtos.Tipo_NotificacionDTO;
import com.example.waryu.Entities.Distrito;
import com.example.waryu.Entities.DistritoFavorito;
import com.example.waryu.Entities.Tipo_Notificacion;
import com.example.waryu.ServiceInterfaces.IDistritoFavoritoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/DistritoFavorito")
public class DistritoFavoritoController {
    @Autowired
    private IDistritoFavoritoService dfS;
    @GetMapping
    @PreAuthorize("hasAuthority('usuario')")
    public ResponseEntity<?> listar() {
        List<DistritoFavoritoSecDTO> lista = dfS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DistritoFavoritoSecDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen distritos favoritos registrados.");
        }
        return ResponseEntity.ok(lista);
    }
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody DistritoFavoritoDTO dto) {
        ModelMapper m = new ModelMapper();
        DistritoFavorito d = m.map(dto, DistritoFavorito.class);
        dfS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Distrito Favorito registrado correctamente.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        DistritoFavorito df = dfS.listId(id);
        if (df == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un distrito favorito con el ID: " + id);
        }
        dfS.delete(id);
        return ResponseEntity.ok("Distrito Favorito con ID " + id + " eliminado");
    }
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody DistritoFavoritoDTO dto) {
        ModelMapper m = new ModelMapper();
        DistritoFavorito d = m.map(dto, DistritoFavorito.class);
        DistritoFavorito existe =dfS.listId(d.getID_DistritoFavorito());
        if(existe == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID " + d.getID_DistritoFavorito());
        }
        dfS.update(d);
        return ResponseEntity.ok("Distrito Favorito modificado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findID(@PathVariable("id") Integer id) {
        DistritoFavorito d = dfS.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        DistritoFavoritoDTO dto = m.map(d, DistritoFavoritoDTO.class);
        return ResponseEntity.ok(dto);
    }
}
