package main.java.com.ModuleFive.model;

public sealed class EmpleadoClass extends Persona permits Desarrollador, Gerente {
    public EmpleadoClass(String name){
        super(name);
    }
}
