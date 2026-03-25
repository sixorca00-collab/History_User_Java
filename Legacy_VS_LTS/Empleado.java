package Legacy_VS_LTS;

public class Empleado {
  
    //Tipos de datos requeridos.
    private byte nivel;
    private short diasVacaciones;
    private int edad;
    private long salarioAnual; //Usar L al asignar
    private float horasExtra; //Usar f al asignar
    private double bono;
    private char genero;
    private Boolean activo;
    //Tipo de objeto
    private String nombreCompleto;

    //Constructor
    public Empleado(byte nivel, short diasVacaciones, int edad, long salarioAnual, float horasExtra, double bono, char genero, Boolean activo, String nombreCompleto){
        this.nivel = nivel;
        this.diasVacaciones = diasVacaciones;
        this.edad = edad;
        this.salarioAnual = salarioAnual;
        this.horasExtra = horasExtra;
        this.bono = bono;
        this.genero = genero;
        this.activo = activo;
        this.nombreCompleto = nombreCompleto;
    }
    // Getters
        public int getEdad(){
            return edad;
        }
        public String getnombreCompleto(){
            return nombreCompleto;
        }

    //Setter 
    public void setActivo(Boolean activo){
        this.activo = activo; //Puede cambiar en cualquier momento
    }
          public static void main(String[] args) {
        Empleado empleado1 = new Empleado((byte) 3, (short) 15, 30, 50000L, 10.5f, 2000.0, 'M', true, "Juan Perez");
        System.out.println("Nombre: " + empleado1.getnombreCompleto());
        System.out.println("Edad: " + empleado1.getEdad());
        System.out.println(empleado1.genero);
    }
}
