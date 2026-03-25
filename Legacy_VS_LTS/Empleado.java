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
    public Empleado(byte nivel, short diasVacaciones, int edad, long salarioAnual, float horasExtra, double bono, char genero, Boolean activo){
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
}
