import java.util.InputMismatchException;
import java.util.Scanner;

public class task_03 {
    public static void main(String[] args) {
        calcularSalarioFinal();
        validarElegibilidad();
    }


static void calcularSalarioFinal() {
    Scanner sc = new Scanner(System.in);

    double salarioBase = 0;
    double bonoMensual = 0.10; // 10% del bono mensual
    byte idEmpleado = 0;
    boolean datosCorrectos = false;

    while (!datosCorrectos) {
        try {
            System.out.println("Ingrese su salario base: ");
            salarioBase = sc.nextDouble();

            System.out.println("Ingrese su bono mensual: ");
            bonoMensual = sc.nextDouble();

            System.out.println("Ingrese su ID de empleado: ");
            idEmpleado = sc.nextByte();

            datosCorrectos = true; // si llega aquí, todo bien

        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar solo números.");
            sc.nextLine(); // limpia el buffer clave
        }
    }

    // Determinar bono extra si ID es par
    double bonoExtra = (idEmpleado % 2 == 0) ? 100.0 : 0.0;

    // Orden de ejecución:
    // 1. Paréntesis
    // 2. Multiplicaciones
    // 3. Suma y resta

    double salarioFinal = (salarioBase + (bonoMensual * 1.10) + bonoExtra) - (salarioBase * 0.05);

    System.out.println("Su salario final es: " + salarioFinal);

}

static void validarElegibilidad() {
    Scanner sc = new Scanner(System.in);

    int puntajeTest = 0;
    int edad = 0;
    int idSede = 0;
    boolean esActivo = false;
    boolean datosCorrectos = false;

    while (!datosCorrectos) {
        try {
            System.out.println("Ingrese su puntaje de test: ");
            puntajeTest = sc.nextInt();

            System.out.println("Ingrese su edad: ");
            edad = sc.nextInt();

            System.out.println("Ingrese su ID de sede: ");
            idSede = sc.nextInt();

            System.out.println("¿Es activo? (true/false): ");
            esActivo = sc.nextBoolean();

            datosCorrectos = true;

        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar solo números o booleanos.");
            sc.nextLine();
        }
    }

    // Lógica booleana compleja: (puntajeTest > 85 && edad < 30) || (idSede == 1 && !esActivo)
    // Precedencia: ! (not) > && (and) > || (or)
    boolean esElegible = (puntajeTest > 85 && edad < 30) || (idSede == 1 && !esActivo);

    System.out.println("¿Es elegible? " + esElegible);

    sc.close(); // tuve un bug por cerrar esto en el otro metodo, así que lo dejo aquí al final
}
}
