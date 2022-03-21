package com.eldar.ejercicioEldar.controller;

import com.eldar.ejercicioEldar.model.Operacion;
import com.eldar.ejercicioEldar.service.IOperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/operacion")
public class OperacionController {

    private IOperacionService operacionService;
    private Double tasa;
    private Double year;
    private Double importeTotal;
    private Double importeFinal;

    @Autowired
    public OperacionController(IOperacionService operacionService) {
        this.operacionService = operacionService;
    }

    @GetMapping(value = "/tasa/{marca}/{fecha}/{importe}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Operacion tasa(@PathVariable String marca, @PathVariable Double importe,
                          @PathVariable(value = "fecha")
                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        Operacion operacion = new Operacion();
        operacion.setImporte(importe);
        operacion.setMarca(marca);
        operacion.setFecha(fecha);
        if (importe < 1000) {
            if (marca.compareTo("visa") == 0) {
                year = (double) (fecha.getYear() - 2000);
                tasa = (year / fecha.getMonthValue());
                importeTotal = (tasa * importe);
                operacion.setTasa(tasa);
                operacion.setImporteTotal(importeTotal);
            } else if (marca.compareTo("nara") == 0) {
                tasa = (fecha.getDayOfMonth() * 0.5);
                importeTotal = (tasa * importe);
                operacion.setTasa(tasa);
                operacion.setImporteTotal(importeTotal);
            } else if (marca.compareTo("amex") == 0) {
                tasa = (fecha.getMonthValue() * 0.1);
                importeTotal = (tasa * importe);
                operacion.setTasa(tasa);
                operacion.setImporteTotal(importeTotal);
            }
        }
        return operacion;
    }

    @PostMapping(value = "/tasa")
    public String tasa(@RequestBody Operacion operacion) {

        if (operacion.getMarca().compareTo("visa") == 0) {
            year = (double) (operacion.getFecha().getYear() - 2000);
            operacion.setTasa(year / operacion.getFecha().getMonthValue());
            importeTotal = (operacion.getTasa() * operacion.getImporte());
            operacion.setImporteTotal(importeTotal);
        } else if (operacion.getMarca().compareTo("nara") == 0) {
            operacion.setTasa((operacion.getFecha().getDayOfMonth() * 0.5));
            importeTotal = (operacion.getTasa() * operacion.getImporte());
            operacion.setImporteTotal(importeTotal);
        } else if (operacion.getMarca().compareTo("amex") == 0) {
            operacion.setTasa((operacion.getFecha().getMonthValue() * 0.5));
            importeTotal = (operacion.getTasa() * operacion.getImporte());
            operacion.setImporteTotal(importeTotal);
        }
        return "La marca de la operacion es : " + operacion.getMarca() + " , la tasa de la operacion es : " + operacion.getTasa() +
                " , el importe total es : $" + operacion.getImporteTotal();
    }
}
