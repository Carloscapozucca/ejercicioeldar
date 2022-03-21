package com.eldar.ejercicioEldar.service;

import com.eldar.ejercicioEldar.model.Operacion;
import com.eldar.ejercicioEldar.repository.OperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperacionService implements IOperacionService{

    @Autowired
    private OperacionRepository operacionRepository;

    public List<Operacion> getOperaciones(){
        return operacionRepository.findAll();
    }

    public Operacion saveOperacion (Operacion operacion){
        try{
            this.operacionRepository.save(operacion);
            return operacion;
        }catch(Exception e){
            return null;
        }
    }

}
