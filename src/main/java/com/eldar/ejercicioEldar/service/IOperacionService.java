package com.eldar.ejercicioEldar.service;

import com.eldar.ejercicioEldar.model.Operacion;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface IOperacionService {

    List<Operacion> getOperaciones() throws ServiceException;

    Operacion saveOperacion(Operacion operacion);
}
