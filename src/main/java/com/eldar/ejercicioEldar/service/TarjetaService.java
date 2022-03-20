package com.eldar.ejercicioEldar.service;

import com.eldar.ejercicioEldar.model.Tarjeta;
import com.eldar.ejercicioEldar.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaService implements ITarjetaService{

    //3245874625492745

    @Autowired
    private TarjetaRepository tarjetaRepository;


    public Tarjeta getTarjeta(String numero){
        return tarjetaRepository.getTarjeta(numero);
    }
}
