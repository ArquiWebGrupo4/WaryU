package com.example.waryu.repositories;

import com.example.waryu.entities.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDistritoRepository extends JpaRepository<Distrito,Integer> {
    @Query("SELECT d.Nombre AS distrito, n.nivel AS nivel_peligro, COUNT(i.ID_Incidente) AS total " +
            "FROM Distrito d " +
            "JOIN Incidente i ON d.ID_Distrito = i.distrito.ID_Distrito " +
            "JOIN Nivel_Peligro n ON i.nivelPeligro.ID_nivel = n.ID_nivel " +
            "WHERE n.nivel = 3 " +
            "GROUP BY d.Nombre, n.nivel " +
            "ORDER BY total DESC")
    List<Object[]> contarIncidentesPorNivel();
}
