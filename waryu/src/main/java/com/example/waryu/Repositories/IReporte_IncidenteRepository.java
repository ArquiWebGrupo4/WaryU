package com.example.waryu.Repositories;

import com.example.waryu.Entities.Reporte_Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReporte_IncidenteRepository extends JpaRepository<Reporte_Incidente, Integer> {
    @Query("select ri from Reporte_Incidente ri where ri.incidente.ID_Incidente =:idincidente")
    public List<Reporte_Incidente> findbyIncidente(@Param("idincidente") Integer idincidente);
}
