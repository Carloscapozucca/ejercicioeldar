package com.eldar.ejercicioEldar.repository;

import com.eldar.ejercicioEldar.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {

    @Query("select t from Tarjeta t where t.nroTarjeta = ?1")
    Tarjeta getTarjeta(String nroTarjeta);

}
