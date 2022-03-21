package com.eldar.ejercicioEldar.service;

import com.eldar.ejercicioEldar.model.Tarjeta;
import com.eldar.ejercicioEldar.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarjetaService implements ITarjetaService{

    //3245874625492745
    @Autowired
    private TarjetaRepository tarjetaRepository;


    public Tarjeta getTarjeta(String nroTarjeta){
        return tarjetaRepository.getTarjeta(nroTarjeta);
    }

    public List<Tarjeta> getTarjetas(){
        return tarjetaRepository.findAll();
    }

    public Tarjeta saveTarjeta (Tarjeta tarjeta){
        try{
            this.tarjetaRepository.save(tarjeta);
            return tarjeta;
        }catch (Exception e){
            return null;
        }
    }
}
