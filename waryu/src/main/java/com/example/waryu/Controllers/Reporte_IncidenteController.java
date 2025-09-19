package com.example.waryu.Controllers;

import com.example.waryu.Dtos.Reporte_IncidenteDTO;
import com.example.waryu.Dtos.Reporte_IncidenteSecDTO;
import com.example.waryu.Dtos.RolDTO;
import com.example.waryu.Dtos.UsuarioDTO;
import com.example.waryu.Entities.Incidente;
import com.example.waryu.Entities.Reporte_Incidente;
import com.example.waryu.Entities.Rol;
import com.example.waryu.Entities.Usuario;
import com.example.waryu.ServiceInterfaces.IReporte_IncidenteService;
import com.example.waryu.ServiceInterfaces.IUsuarioService;
import com.example.waryu.ServiceInterfaces.IncidenteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reportes")
public class Reporte_IncidenteController {
    @Autowired
    private IReporte_IncidenteService rIS;
    @Autowired
    private IUsuarioService uS;
    @Autowired
    private IncidenteService iS;
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Reporte_IncidenteSecDTO> lista = rIS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Reporte_IncidenteSecDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen reportes registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody Reporte_IncidenteDTO dto) {
        ModelMapper m = new ModelMapper();
        Reporte_Incidente d = m.map(dto, Reporte_Incidente.class);

        Usuario usuario = d.getUsuario();

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe el usuario ingresado");
        }
        Incidente incidente = d.getIncidente();
        if (incidente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe el incidente ingresado");
        }

        rIS.insert(d);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Reporte registrado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Reporte_Incidente reporteincidente = rIS.findID(id);
        if (reporteincidente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un reporte con el ID: " + id);
        }
        rIS.delete(id);
        return ResponseEntity.ok("Rol con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody Reporte_IncidenteDTO dto) {
        ModelMapper m = new ModelMapper();
        Reporte_Incidente r = m.map(dto, Reporte_Incidente.class);
        Reporte_Incidente existe =rIS.findID(r.getID_Reporte());
        if(existe == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID " + r.getID_Reporte());
        }
        rIS.update(r);
        return ResponseEntity.ok("Reporte de incidente modificado correctamente.");
    }
}
