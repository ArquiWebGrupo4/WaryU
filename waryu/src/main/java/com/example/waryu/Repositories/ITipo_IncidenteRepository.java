package com.example.waryu.Repositories;


import com.example.waryu.Entities.Tipo_Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipo_IncidenteRepository extends JpaRepository<Tipo_Incidente,Integer> {

}
