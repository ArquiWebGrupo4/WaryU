package com.example.waryu.repositories;

import com.example.waryu.entities.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IncidenteRepository extends JpaRepository<Incidente,Integer> {
    @Query("select i from Incidente i where i.Fecha_Modificacion between :fecha1 and :fecha2")
    public List<Incidente> listarentrefechas(@Param("fecha1") LocalDateTime fecha1, @Param("fecha2") LocalDateTime fecha2);

    @Query("select i from Incidente i where i.distrito.Nombre = :distrito")
    public List<Incidente> listardedistrito(@Param("distrito") String distrito);

    @Query(value = "Select ti.tipo as tipo_incidente, COUNT(i.id_incidente) as total_incidentes " +
            "From tipo_incidente ti " +
            "Inner join incidente i on ti.id_tipo_incidente = i.id_tipo " +
            "Group by ti.tipo",
            nativeQuery = true)
    public List<String[]> contarIncidentesPorTipo();

    @Query(value = "Select np.nivel as Nivel_Peligro, COUNT(i.id_incidente) as total_incidentes " +
            "From nivel_peligro np " +
            "Inner join incidente i on np.id_nivel = i.id_nivel " +
            "Group by np.nivel",
            nativeQuery = true)
    public List<String[]> contarIncidentesPorNivel();

    @Query(value = "SELECT d.id_distrito AS idDistrito, d.nombre AS nombreDistrito, COUNT(i.id_incidente) AS totalIncidentes " +
            "FROM distrito d " +
            "JOIN incidente i ON d.id_distrito = i.id_distrito " +
            "GROUP BY d.id_distrito, d.nombre", nativeQuery = true)
    public List<String[]> contarIncidentesPorDistrito();


}
