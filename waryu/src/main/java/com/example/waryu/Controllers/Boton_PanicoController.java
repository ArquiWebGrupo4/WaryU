package com.example.waryu.Controllers;

import com.example.waryu.Dtos.Boton_PanicoDTO;
import com.example.waryu.Dtos.Boton_PanicoSecDTO;
import com.example.waryu.Entities.Boton_Panico;
import com.example.waryu.Entities.Busqueda;
import com.example.waryu.ServiceInterfaces.IBoton_PanicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/botonpanico")
public class Boton_PanicoController {
    @Autowired
    private IBoton_PanicoService btn_pan;

    @GetMapping
    public ResponseEntity<?> listarBoton_Panico()
    {
        List<Boton_PanicoSecDTO> lista = btn_pan.list().stream().map(x->{
            ModelMapper mapper = new ModelMapper();
            return mapper.map(x, Boton_PanicoSecDTO.class);
        }).collect(Collectors.toList());
        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("No existen registros de boton de panico accionados");
        }
        return ResponseEntity.ok(lista);
    }
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody Boton_PanicoDTO dto){
        ModelMapper mapper = new ModelMapper();
        Boton_Panico d = mapper.map(dto, Boton_Panico.class);
        btn_pan.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED).body("Boton de panico accionado registrado");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Boton_Panico d = btn_pan.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        btn_pan.delete(id);
        return ResponseEntity.ok("Busqueda con ID " + id + " eliminado");
    }
}
