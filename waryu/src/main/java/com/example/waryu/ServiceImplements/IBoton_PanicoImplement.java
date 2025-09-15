package com.example.waryu.ServiceImplements;

import com.example.waryu.Entities.Boton_Panico;
import com.example.waryu.Repositories.IBoton_PanicoRepository;
import com.example.waryu.ServiceInterfaces.IBoton_PanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
