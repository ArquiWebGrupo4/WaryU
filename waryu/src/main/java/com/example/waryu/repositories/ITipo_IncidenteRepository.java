package com.example.waryu.repositories;


import com.example.waryu.entities.Tipo_Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipo_IncidenteRepository extends JpaRepository<Tipo_Incidente,Integer> {
    @Query(value = "SELECT r.Tipo AS tipo, COUNT(i.id_incidente) AS total " +
            "FROM tipo_incidente r " +
            "JOIN incidente i ON r.id_tipo_incidente = i.id_tipo_incidente " +
            "WHERE r.Tipo =:tipodesc " +
            "GROUP BY r.Tipo", nativeQuery = true)
    public List<Object[]> cantidadtipoincidente(@Param("tipodesc")  String tipodesc);
}
