package com.eldar.ejercicioEldar.service;

import com.eldar.ejercicioEldar.model.Tarjeta;
import org.hibernate.service.spi.ServiceException;

import java.util.List;


public interface ITarjetaService {

    Tarjeta getTarjeta(String nroTarjeta);

    List<Tarjeta> getTarjetas() throws ServiceException;

    Tarjeta saveTarjeta(Tarjeta tarjeta);
}
