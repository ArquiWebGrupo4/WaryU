package com.example.waryu.repositories;

import com.example.waryu.entities.Boton_Panico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IBoton_PanicoRepository extends JpaRepository<Boton_Panico,Integer> {
    @Query("Select a from Boton_Panico a where a.Fecha_Activacion between :fechaini and :fechafin")
    public List<Boton_Panico> Buscarporfecha(@Param("fechaini") LocalDateTime fechaini, @Param("fechafin") LocalDateTime fechafin);
}
