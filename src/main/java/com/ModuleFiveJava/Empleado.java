package com.ModuleFiveJava;

public record Empleado(String name, int age, boolean isRemote, long SalaryByMoth) {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Juanchito", 19, true, 2000);
    }
}
