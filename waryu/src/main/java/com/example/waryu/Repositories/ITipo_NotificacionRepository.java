package com.example.waryu.Repositories;

import com.example.waryu.Entities.Tipo_Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipo_NotificacionRepository extends JpaRepository<Tipo_Notificacion,Integer> {
}
