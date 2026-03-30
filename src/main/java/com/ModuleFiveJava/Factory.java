package com.ModuleFiveJava;

public record Factory(String nameCompany, byte sedes, String area) {
    public static void main(String[] args) {
        Factory test = new Factory("RiwiCorp2026", (byte)3, "Desarrollo");
        System.out.println(test);
    }
}

