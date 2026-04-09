package main.java.com.ModuleFive;
import main.java.com.ModuleFive.service.EmployeeService;
import main.java.com.ModuleFive.service.CompaniesService;
import main.java.com.ModuleFive.commands.*;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        EmployeeService serviceEmploy = new EmployeeService();
        CompaniesService serviceCompany = new CompaniesService();
        Scanner sc = new Scanner(System.in);
        var exit = false;

        var Menu = """
               
               ====== MENÚ PRINCIPAL ======
               1.  Add employee
               2.  Show all employees
               3.  Eliminar producto
               4.  Buscar producto
               5.  Actualizar producto
               6.  Ver carrito
               7.  Vaciar carrito
               8.  Realizar compra
               9.  Ver historial de compras
               10. Configuración
               0. Salir
               ============================
               
               Seleccione una opción:
               """;

        System.out.println(Menu);

        while (!exit){
            System.out.println(Menu);
            if (!sc.hasNextInt()){
                System.out.println("Error: Debes ingresar un numero.");
                sc.nextLine();
                continue;
            }
            int option = sc.nextInt();
            var faltan = "Aun no terminado";
            sc.nextLine();
            switch (option){
                case 1: new createEmployCommand(serviceEmploy, sc).execute();
                break;
                case 2: new createFactoryCommand(sc, serviceCompany).execute();
                break;
                case 3: new ShowUsersCommand(serviceEmploy).execute();
                break;
                case 4:
                    System.out.println(faltan);
                break;
                case 5:
                    System.out.println(faltan);
                    break;
                case 6:
                    System.out.println(faltan);
                    break;
                case 7:
                    System.out.println(faltan);
                    break;
                case 8:
                    System.out.println(faltan);
                    break;
                case 9:
                    System.out.println(faltan);
                    break;
                case 10:
                    System.out.println(faltan);
                    break;
                case 0:
                    System.out.println("Leaving...");
                    exit = true;
                    break;
            }

        }


    }
}
