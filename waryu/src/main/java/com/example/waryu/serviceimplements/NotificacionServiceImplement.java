package com.example.waryu.serviceimplements;

import com.example.waryu.entities.Notificacion;
import com.example.waryu.repositories.INotificacionRepository;
import com.example.waryu.serviceinterfaces.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionServiceImplement implements INotificacionService {
    @Autowired
    private INotificacionRepository nR;
    @Override
    public List<Notificacion> List() {
        return nR.findAll();
    }

    @Override
    public void Insert(Notificacion notificacion) {
        nR.save(notificacion);
    }

    @Override
    public void Delete(int ID_Notificacion) {
        nR.deleteById(ID_Notificacion);
    }

    @Override
    public Notificacion ListarId(int ID_Notificacion) {
        return nR.findById(ID_Notificacion).orElse(null) ;
    }

    @Override
    public void update(Notificacion notificacion) {
        nR.save(notificacion);
    }
}
