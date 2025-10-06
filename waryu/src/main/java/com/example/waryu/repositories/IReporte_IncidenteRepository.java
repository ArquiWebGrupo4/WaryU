package com.example.waryu.repositories;

import com.example.waryu.entities.Incidente;
import com.example.waryu.entities.Reporte_Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReporte_IncidenteRepository extends JpaRepository<Reporte_Incidente, Integer> {
    @Query("select ri from Reporte_Incidente ri where ri.incidente.ID_Incidente =:idincidente")
    public List<Reporte_Incidente> findbyIncidente(@Param("idincidente") Integer idincidente);
    @Query(value = "Select r.id_incidente as Id_Incidente, COUNT(r.id_reporte) as total_reportes " +
            "From Reporte_Incidente r " +
            "Group by r.id_incidente", nativeQuery = true)
    public List<String[]> ContarPorIncidente();



}
