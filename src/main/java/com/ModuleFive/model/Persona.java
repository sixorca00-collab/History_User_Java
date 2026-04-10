package main.java.com.ModuleFive.model;

public abstract sealed class Persona permits EmpleadoClass, ConsultorExterno {
    protected String name;

    public Persona(String name){
        this.name = name;
    }

    public String getname() {
        return name;
    }


}
