package com.example.waryu.Repositories;

import com.example.waryu.Entities.Boton_Panico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoton_PanicoRepository extends JpaRepository<Boton_Panico,Integer> {
}
