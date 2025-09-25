package com.example.waryu.repositories;

import com.example.waryu.entities.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {
}
