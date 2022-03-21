package com.eldar.ejercicioEldar.view;

import com.eldar.ejercicioEldar.model.Tarjeta;
import com.eldar.ejercicioEldar.model.Tarjeta2;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        Collator comparador = Collator.getInstance();
        Tarjeta2 tarjeta2 = new Tarjeta2();
        System.out.println("Ingrese marca de la tarjeta (visa, nara, amex) :");
        tarjeta2.setMarca(scanner.next());
        System.out.println("Ingrese numero de tarjeta 16 digitos :");
        try{
            tarjeta2.setNroTarjeta(scanner.nextLong());
        }catch(Exception e){
            System.out.println("No es un numero");
        }
        System.out.println("Ingrese Nombre y Apellido :");
        tarjeta2.setCardHolder(scanner.next());
        System.out.println("Ingrese fecha de vencimiento :");
        tarjeta2.setFechaVencimiento(scanner.next());
        if(comparador.compare(tarjeta2.getFechaVencimiento(), "2022-03-21") < 0){
            System.out.println("La tarjeta es invalida para operar");
            tarjeta2.setFechaVencimiento(null);
        }
        System.out.println("Ingrese importe :");
        try{
            tarjeta2.setImporte(scanner.nextDouble());
            if(tarjeta2.getImporte() > 1000){
                System.out.println("La operacion es invalida.");
                tarjeta2.setImporte(null);
            }
        }catch(Exception e){
            System.out.println("No es un numero");
        }
        if (tarjeta2.getImporte() != null && tarjeta2.getFechaVencimiento() != null) {
            System.out.println("\n" + tarjeta2.devolverInfo(tarjeta2));
        }
    }
}
