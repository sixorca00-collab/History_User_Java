package main.java.com.ModuleFive.model;

public abstract sealed class Persona permits EmpleadoClass, ConsultorExterno {
    protected String name;

    public Persona(String name){
        this.name = name;
    }

    public String getname() {
        return name;
    }

    /* * Las Sealed Classes permiten manejar la herencia de modo seguro al restringir
      qué clases pueden ser herederas mediante la palabra reservada 'permits'.
      A diferencia de la herencia abierta, esto garantiza un sistema de tipos cerrado
      que proporciona control total sobre el instanciamiento y la jerarquía de la API.
      Esto permite que el compilador verifique que todos los casos posibles estén
      cubiertos, evitando errores por tipos no previstos por el desarrollador.
     */
}
