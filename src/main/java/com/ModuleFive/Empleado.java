package main.java.com.ModuleFive;

public record Empleado(int id,  String name, int age, boolean isRemote, long SalaryByMoth) {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado(00 , "Juanchito", 19, true, 2000);
    }
}
