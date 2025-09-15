package com.example.waryu.Controllers;

import com.example.waryu.Dtos.Boton_PanicoDTO;
import com.example.waryu.Entities.Boton_Panico;
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
        List<Boton_PanicoDTO> lista = btn_pan.list().stream().map(x->{
            ModelMapper mapper = new ModelMapper();
            return mapper.map(x, Boton_PanicoDTO.class);
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

}
