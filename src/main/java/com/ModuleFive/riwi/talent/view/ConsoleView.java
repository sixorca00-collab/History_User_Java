package com.riwi.talent.view;

import com.riwi.talent.controller.EmpleadoController;
import com.riwi.talent.model.entity.Empleado;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleView {

    private final Scanner sc = new Scanner(System.in);
    private final EmpleadoController controller = new EmpleadoController();

    private static final String MENU = """
            
            ╔══════════════════════════════════╗
            ║    CORPORATE TALENT HUB v2.0     ║
            ╠══════════════════════════════════╣
            ║  1. Agregar empleado             ║
            ║  2. Listar empleados             ║
            ║  3. Buscar empleado por ID       ║
            ║  4. Actualizar empleado          ║
            ║  5. Eliminar empleado            ║
            ║  6. Reporte consolidado          ║
            ║  0. Salir                        ║
            ╚══════════════════════════════════╝
            Seleccione una opción:\s""";

    public void iniciar() {
        boolean activo = true;
        while (activo) {
            System.out.print(MENU);
            if (!sc.hasNextInt()) {
                System.out.println("Error: ingresa un número válido.");
                sc.nextLine();
                continue;
            }
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> mostrarAgregarEmpleado();
                case 2 -> mostrarListaEmpleados();
                case 3 -> mostrarBuscarEmpleado();
                case 4 -> mostrarActualizarEmpleado();
                case 5 -> mostrarEliminarEmpleado();
                case 6 -> mostrarReporte();
                case 0 -> {
                    System.out.println("Saliendo del sistema...");
                    activo = false;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarAgregarEmpleado() {
        System.out.println("\n── Agregar Empleado ──");
        System.out.print("Nombre: ");
        String name = sc.nextLine();

        System.out.print("Edad: ");
        int age = leerEntero();

        System.out.print("¿Trabaja remoto? (true/false): ");
        boolean isRemote = sc.nextBoolean();
        sc.nextLine();

        System.out.print("Salario mensual: ");
        long salary = leerLong();

        controller.registrarEmpleado(name, age, isRemote, salary);
    }

    private void mostrarListaEmpleados() {
        System.out.println("\n── Lista de Empleados ──");
        List<Empleado> lista = controller.obtenerTodos();
        if (lista.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        lista.forEach(e -> System.out.printf(
                "ID: %d | %-20s | Edad: %d | %-12s | Salario: $%d%n",
                e.id(), e.name(), e.age(),
                e.isRemote() ? "Remoto" : "Presencial",
                e.salaryByMonth()));
    }

    private void mostrarBuscarEmpleado() {
        System.out.println("\n── Buscar Empleado ──");
        System.out.print("Ingresa el ID: ");
        int id = leerEntero();
        Optional<Empleado> resultado = controller.buscarPorId(id);
        resultado.ifPresentOrElse(
                e -> System.out.printf("Encontrado: %s | Edad: %d | Salario: $%d%n",
                        e.name(), e.age(), e.salaryByMonth()),
                () -> System.out.println("Empleado no encontrado.")
        );
    }

    private void mostrarActualizarEmpleado() {
        System.out.println("\n── Actualizar Empleado ──");
        System.out.print("ID del empleado a actualizar: ");
        int id = leerEntero();

        System.out.print("Nuevo nombre: ");
        String name = sc.nextLine();

        System.out.print("Nueva edad: ");
        int age = leerEntero();

        System.out.print("¿Remoto? (true/false): ");
        boolean isRemote = sc.nextBoolean();
        sc.nextLine();

        System.out.print("Nuevo salario: ");
        long salary = leerLong();

        controller.actualizarEmpleado(id, name, age, isRemote, salary);
    }

    private void mostrarEliminarEmpleado() {
        System.out.println("\n── Eliminar Empleado ──");
        System.out.print("ID del empleado a eliminar: ");
        int id = leerEntero();
        controller.eliminarEmpleado(id);
    }

    private void mostrarReporte() {
        System.out.println("\n── Reporte Consolidado de Empleados ──");
        System.out.println(controller.generarReporteTexto());
    }

    private int leerEntero() {
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número entero válido: ");
            sc.nextLine();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    private long leerLong() {
        while (!sc.hasNextLong()) {
            System.out.print("Ingresa un número válido: ");
            sc.nextLine();
        }
        long valor = sc.nextLong();
        sc.nextLine();
        return valor;
    }
}
