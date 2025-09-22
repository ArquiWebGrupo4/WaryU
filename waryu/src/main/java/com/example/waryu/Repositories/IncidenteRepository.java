package com.example.waryu.Repositories;

import com.example.waryu.Entities.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IncidenteRepository extends JpaRepository<Incidente,Integer> {
    @Query("select i from Incidente i where i.Fecha_Modificacion between :fecha1 and :fecha2")
    public List<Incidente> listarentrefechas(@Param("fecha1") LocalDateTime fecha1, @Param("fecha2") LocalDateTime fecha2);

    @Query("select i from Incidente i where i.distrito.Nombre = :distrito")
    public List<Incidente> listardedistrito(@Param("distrito") String distrito);
}
