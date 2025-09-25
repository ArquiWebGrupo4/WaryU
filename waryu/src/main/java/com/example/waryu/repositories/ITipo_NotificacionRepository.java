package com.example.waryu.repositories;

import com.example.waryu.entities.Tipo_Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipo_NotificacionRepository extends JpaRepository<Tipo_Notificacion,Integer> {
}
