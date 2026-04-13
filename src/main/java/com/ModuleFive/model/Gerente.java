package main.java.com.ModuleFive.model;

public final class Gerente extends EmpleadoClass {

    private double presupuestoMensual;

    public Gerente(String name, double presupuestoMensual){
        super(name);
        this.presupuestoMensual = presupuestoMensual;
    }

    public double getPresupuestoMensual() {
        return presupuestoMensual;
    }
}