package com.example.waryu.ServiceImplements;

import com.example.waryu.Entities.Tipo_Notificacion;
import com.example.waryu.Repositories.ITipo_NotificacionRepository;
import com.example.waryu.ServiceInterfaces.ITipo_NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ITipo_NotificacionImplement implements ITipo_NotificacionService {
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
}
