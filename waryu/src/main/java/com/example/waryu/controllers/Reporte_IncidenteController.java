package com.example.waryu.controllers;

import com.example.waryu.dtos.Reporte_IncidenteDTO;
import com.example.waryu.dtos.Reporte_IncidenteSecDTO;
import com.example.waryu.dtos.Reporte_IncidentexDistritoDTO;
import com.example.waryu.dtos.Reporte_ReportesxIncidenteDTO;
import com.example.waryu.entities.*;
import com.example.waryu.serviceinterfaces.IReporte_IncidenteService;
import com.example.waryu.serviceinterfaces.IUsuarioService;
import com.example.waryu.serviceinterfaces.IncidenteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @PreAuthorize("hasAnyAuthority('PADRE', 'ESTUDIANTE', 'ADMIN')")
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

    @GetMapping("/{id}")
    public ResponseEntity<?> findID(@PathVariable("id") Integer id) {
        Reporte_Incidente ri = rIS.findID(id);
        if (ri == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe registros, con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        Reporte_IncidenteSecDTO  dto = m.map(ri, Reporte_IncidenteSecDTO.class);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/ReporteByIncidente")
    public ResponseEntity<?> findReporteByIncidente(@RequestParam("id") int id) {
        List<Reporte_Incidente> list = rIS.findbyIncidente(id);
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existen reportes registrados del incidente.");
        }
        List<Reporte_IncidenteSecDTO> dto = list.stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, Reporte_IncidenteSecDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/ContarPorTipoIncidente")
    public ResponseEntity<?> contarPorTipoIncidente() {
        List<Reporte_ReportesxIncidenteDTO>listado = new ArrayList<Reporte_ReportesxIncidenteDTO>();
        List<String[]>filas=rIS.ContarPorIncidente();
        if (filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen registros");

        }
        for(String[] x:filas) {
            Reporte_ReportesxIncidenteDTO dto=new Reporte_ReportesxIncidenteDTO();
            dto.setIncidente(x[0]);
            dto.setCantidad(Integer.parseInt(x[1]));
            listado.add(dto);
        }
        return ResponseEntity.ok(listado);
    }
}
