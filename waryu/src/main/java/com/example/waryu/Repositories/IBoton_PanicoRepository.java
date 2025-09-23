package com.example.waryu.Repositories;

import com.example.waryu.Entities.Boton_Panico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBoton_PanicoRepository extends JpaRepository<Boton_Panico,Integer> {
    @Query("Select * from boton_panico a where a.fecha_activacion between fechaini and fechafin;")
    public List<Boton_Panico> Buscarporfecha(@Param("fechaini") LocalDate fechaini, @Param("fechafin") LocalDate fechafin);
}
