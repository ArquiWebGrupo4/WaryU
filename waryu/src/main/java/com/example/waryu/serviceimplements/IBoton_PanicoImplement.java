package com.example.waryu.serviceimplements;

import com.example.waryu.entities.Boton_Panico;
import com.example.waryu.repositories.IBoton_PanicoRepository;
import com.example.waryu.serviceinterfaces.IBoton_PanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IBoton_PanicoImplement implements IBoton_PanicoService {
    @Autowired
    private IBoton_PanicoRepository btn_Pan;

    @Override
    public void insert(Boton_Panico boton_panico){
        btn_Pan.save(boton_panico);
    }
    @Override
    public List<Boton_Panico> list(){
        return btn_Pan.findAll();
    }

    @Override
    public void delete(int id) {
        btn_Pan.deleteById(id);
    }

    @Override
    public Boton_Panico listId(int id) {
        return  btn_Pan.findById(id).orElse(null);
    }

    @Override
    public void update(Boton_Panico panico) {
        btn_Pan.save(panico);
    }

    @Override
    public List<Boton_Panico> Buscarporfechas(LocalDateTime fechaini, LocalDateTime fechafin){
        return btn_Pan.Buscarporfecha(fechaini,fechafin);
    }
}
