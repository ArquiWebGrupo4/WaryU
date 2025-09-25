package com.example.waryu.serviceimplements;

import com.example.waryu.entities.Tipo_Notificacion;
import com.example.waryu.repositories.ITipo_NotificacionRepository;
import com.example.waryu.serviceinterfaces.ITipo_NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Tipo_NotificacionServiceImplement implements ITipo_NotificacionService {
    @Autowired
    private ITipo_NotificacionRepository nTN;

    @Override
    public List<Tipo_Notificacion> list() {
        return nTN.findAll();
    }

    @Override
    public void insert(Tipo_Notificacion tipo) {
        nTN.save(tipo);

    }


    @Override
    public void delete(int id) {
        nTN.deleteById(id);

    }

    @Override
    public Tipo_Notificacion listId(int id) {
        return nTN.findById(id).orElse(null);
    }

    @Override
    public void update(Tipo_Notificacion tipo) {
        nTN.save(tipo);
    }
}
