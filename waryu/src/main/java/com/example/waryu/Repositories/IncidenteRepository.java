package com.example.waryu.Repositories;

import com.example.waryu.Entities.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenteRepository extends JpaRepository<Incidente,Integer> {
}
