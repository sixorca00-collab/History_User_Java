package main.java.com.ModuleFive.model;

import main.java.com.ModuleFive.commands.Promocionable;

public sealed class EmpleadoClass
        extends Persona
        implements Promocionable
        permits Desarrollador, Gerente {

    protected double salario = 1500;

    public EmpleadoClass(String name){
        super(name);
    }

    @Override
    public double CalcularBono() {
        return salario * 0.10;
    }
}