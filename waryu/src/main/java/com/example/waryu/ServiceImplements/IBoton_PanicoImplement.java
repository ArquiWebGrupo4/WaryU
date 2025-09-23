package com.example.waryu.ServiceImplements;

import com.example.waryu.Entities.Boton_Panico;
import com.example.waryu.Repositories.IBoton_PanicoRepository;
import com.example.waryu.ServiceInterfaces.IBoton_PanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<Boton_Panico> Buscarporfechas(LocalDate fechaini, LocalDate fechafin){
        return btn_Pan.Buscarporfecha(fechaini,fechafin);
    }
}
