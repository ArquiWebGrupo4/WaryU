package com.example.waryu.Repositories;


import com.example.waryu.Entities.Tipo_Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipo_IncidenteRepository extends JpaRepository<Tipo_Incidente,Integer> {
    @Query("select a.tipo, count(*) as total \n" +
            "from tipo_incidente a \n" +
            "where a.tipo = 'tipodesc' \n" +
            "group by a.tipo;")
    public List<Tipo_Incidente> cantidadtipoincidente(@Param("tipodesc")  String tipodesc);
}
