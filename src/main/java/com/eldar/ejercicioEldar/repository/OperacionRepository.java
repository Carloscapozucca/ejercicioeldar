package com.eldar.ejercicioEldar.repository;

import com.eldar.ejercicioEldar.model.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperacionRepository extends JpaRepository<Operacion, Long> {

}
