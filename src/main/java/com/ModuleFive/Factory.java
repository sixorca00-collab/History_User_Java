package main.java.com.ModuleFive;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record Factory(String nameCompany, byte sedes, String area, List<String> tecnologias, Map<String, String> sedesDetalle) {

    public static void main(String[] args) {
        List<String> tech = List.of("Software","Hardware","IA");
        Map<String, String> detalles = Map.of("Sede1:","Boyota","Sede2","Medellin");
        Factory test = new Factory("RiwiCorp2026", (byte)3, "Desarrollo", tech, detalles);
        System.out.println(test);
    }


}

