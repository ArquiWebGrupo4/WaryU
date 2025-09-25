package com.example.waryu.serviceinterfaces;

import com.example.waryu.entities.Tipo_Notificacion;

import java.util.List;

public interface ITipo_NotificacionService {
    public List<Tipo_Notificacion> list();
    public void insert(Tipo_Notificacion tipo);
    public void delete(int id);
    public Tipo_Notificacion listId(int id);
    public void update(Tipo_Notificacion tipo);

}
