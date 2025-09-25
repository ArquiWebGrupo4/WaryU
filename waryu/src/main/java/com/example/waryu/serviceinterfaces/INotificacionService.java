package com.example.waryu.serviceinterfaces;

import com.example.waryu.entities.Notificacion;

import java.util.List;

public interface INotificacionService {
    public List<Notificacion> List();
    public void Insert(Notificacion notificacion);
    public void Delete(int ID_Notificacion);
    public Notificacion ListarId(int ID_Notificacion);
    public void update(Notificacion notificacion);
}
