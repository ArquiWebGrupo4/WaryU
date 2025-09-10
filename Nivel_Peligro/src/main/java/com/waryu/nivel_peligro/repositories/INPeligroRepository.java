package com.waryu.nivel_peligro.repositories;

import com.waryu.nivel_peligro.entities.Nivel_Peligro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INPeligroRepository extends JpaRepository<Nivel_Peligro, Integer> {

}
