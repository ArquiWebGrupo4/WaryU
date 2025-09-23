package com.example.waryu.Repositories;

import com.example.waryu.Dtos.DistritoPeligrosoDTO;
import com.example.waryu.Entities.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDistritoRepository extends JpaRepository<Distrito,Integer> {
    @Query(value = "SELECT d.nombre AS distrito, n.nivel AS nivel_peligro, COUNT(i.id_incidente) AS total " +
            "FROM distrito d " +
            "JOIN incidente i ON d.id_distrito = i.id_distrito " +
            "JOIN nivel_peligro n ON i.id_nivel = n.id_nivel " +
            "WHERE n.nivel = 3 " +
            "GROUP BY d.nombre, n.nivel " +
            "ORDER BY total DESC",
            nativeQuery = true)
    List<Object[]> contarIncidentesPorNivel();
}
