package main.java.com.ModuleFive.commands;

import java.time.LocalDateTime;

public interface Promocionable {

    double CalcularBono();

    default void registrarOperacion(String detalle){
        System.out.println(LocalDateTime.now() + " - " + detalle);
    }
}