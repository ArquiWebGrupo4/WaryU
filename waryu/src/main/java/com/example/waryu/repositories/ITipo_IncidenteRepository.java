package com.example.waryu.repositories;


import com.example.waryu.entities.Tipo_Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipo_IncidenteRepository extends JpaRepository<Tipo_Incidente,Integer> {
    @Query("select a.Tipo_Tipo_Incidente, count(a.Id_Tipo_Incidente) as total \n" +
            "from Tipo_Incidente a \n" +
            "where a.Tipo_Tipo_Incidente = :tipodesc \n" +
            "group by a.Tipo_Tipo_Incidente")
    public List<Object[]> cantidadtipoincidente(@Param("tipodesc")  String tipodesc);
}
