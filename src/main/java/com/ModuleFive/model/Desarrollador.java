package main.java.com.ModuleFive.model;

public final class Desarrollador extends EmpleadoClass {

    private int id;
    private String lenguajePrincipal;

    public Desarrollador(int id, String name,  String lenguajePrincipal){
        super(name);
        this.id = id;
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }
}
