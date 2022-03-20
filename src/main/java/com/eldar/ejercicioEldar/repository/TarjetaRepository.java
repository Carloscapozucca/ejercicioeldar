package com.eldar.ejercicioEldar.repository;

import com.eldar.ejercicioEldar.model.Tarjeta;
import org.springframework.data.jpa.repository.Query;


public interface TarjetaRepository {

    @Query("select t from Tarjeta t where t.nroTarjeta = ?1")
    Tarjeta getTarjeta(String numero);

}
