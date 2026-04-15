package main.java.com.ModuleFive;
import main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.model.EmpleadoClass;
import main.java.com.ModuleFive.service.EmployeeService;
import main.java.com.ModuleFive.service.CompaniesService;
import main.java.com.ModuleFive.commands.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeService serviceEmploy = new EmployeeService();
        CompaniesService serviceCompany = new CompaniesService();
        Scanner sc = new Scanner(System.in);
        var exit = false;

        var Menu = """
               
               ====== MENÚ PRINCIPAL ======
               1. Add employee
               2. Add company
               3. Show all employees
               4. Show salary category
               5. Show Last Employ.
               6. Show firts employ
               7. Remove employee by id
               8. Pet fist, last and reversed Employs
               9. Performance report.
               10.Performance salary total.
               11.Performance report
               12.Validate employability
               13.Bonus calculation
               0. Exit
               ============================
               
               Seleccione una opción:
               """;

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
                    new getSalarialCategoryCommand(sc, serviceEmploy).execute();
                break;
                case 5:
                    new showLastUserCommand(serviceEmploy).execute();
                    break;
                case 6:
                    new showFirtEmployCommand(serviceEmploy).execute();
                    break;
                case 7:
                    new removeEmployByIdCommand(serviceEmploy, sc).execute();
                    break;
                case 8:
                    new getFistLastandReversedCommand(serviceEmploy).execute();
                    break;
                case 9:
                  new removeEmployByScoreCommand(serviceEmploy, sc).execute();
                    break;
                case 10:
                    new TotalPromedioCommand(serviceEmploy).execute();
                    break;
                case 11:
                    new desempeñoReporteCommand( serviceEmploy, sc).execute();
                case 12:
                    new validarPersonaCommand(serviceEmploy).execute();
                    break;
                case 13:
                    new CalcularBonoCommand(serviceEmploy).execute();
                    break;
                case 0:
                    System.out.println("Leaving...");
                    exit = true;
                    break;
                default:
                    System.out.println("Seleccione una opcion valida");
            }

        }


    }
}
