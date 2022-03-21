package com.eldar.ejercicioEldar.model;

import java.time.LocalDate;

public class Tarjeta2 {

    private String marca;
    private Long nroTarjeta;
    private String cardHolder;
    private Double importe;
    private String fechaVencimiento;

    public String devolverInfo(Tarjeta2 tarjeta2){
        return "Marca: " + tarjeta2.getMarca() + "\n"
                + "Numero tarjeta : " + tarjeta2.getNroTarjeta() + "\n"
                + "CardHolder : " + tarjeta2.getCardHolder() + "\n"
                + "Fecha Vencimiento : " + tarjeta2.getFechaVencimiento() + "\n"
                + "Importe : " + tarjeta2.getImporte();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Long getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(Long nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
