package com.eldar.ejercicioEldar.controller;

import com.eldar.ejercicioEldar.model.Tarjeta;
import com.eldar.ejercicioEldar.service.ITarjetaService;
import com.eldar.ejercicioEldar.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {

    private ITarjetaService tarjetaService;

    @Autowired
    public TarjetaController(ITarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }

    @GetMapping(value = "/{nroTarjeta}")
    public Tarjeta getTarjeta(@PathVariable String nroTarjeta) {
        return tarjetaService.getTarjeta(nroTarjeta);
    }

    @GetMapping(value = "/tarjetas")
    public List<Tarjeta> getTarjetas() {
        return tarjetaService.getTarjetas();
    }

    @PostMapping(value = "/savetarjeta")
    public Tarjeta saveTarjeta(@RequestBody Tarjeta tarjeta) {
        return this.tarjetaService.saveTarjeta(tarjeta);
    }

}
