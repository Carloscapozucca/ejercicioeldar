package com.eldar.ejercicioEldar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tarjeta")
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String marca;
    private String nroTarjeta;

    private String cardHolder;
    private Double importe;
    private LocalDate fechaVencimiento;


}
