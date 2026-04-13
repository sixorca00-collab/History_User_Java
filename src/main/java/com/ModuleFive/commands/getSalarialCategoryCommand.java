package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class getSalarialCategoryCommand implements menuCommand{
    private final  EmployeeService service;
    private final Scanner sc;

    public getSalarialCategoryCommand(Scanner sc, EmployeeService service){
        this.service = service;
        this.sc = sc;
    }
@Override
    public void execute(){
        System.out.println("List of employees: ");
        List<Empleado> employs = service.getEmployees();


        if (employs == null || employs.isEmpty()){
            System.out.println("Don't have employs registered.");
            return;
        }
        //Los muestro.
        for (Empleado e : employs){
            System.out.println("Id: " + e.id() +
                    " Name: " + e.name() +
                    " Salary: " + e.SalaryByMoth());
        }
        //Especificar empleado
        System.out.println("Give the id: ");
        var id = sc.nextInt();
        //Defino cual va a ser.
        Empleado search = null;
        for (Empleado e : service.getEmployees()){
            if (e.id() == id){
                search = e;
                break;
            }
        }
        //Validamos
        if (search == null){
            System.out.println("Employee not found");
            return;
        }
        //Vemos el salario del fulano
        var salary = search.SalaryByMoth();
        String category = switch ((int) salary) {
            case int s when s <= 1000 -> "Junior Developer";
            case int s when s <= 2500 -> "Mid Developer";
            case int s when s <= 3000 -> "Senior Developer";
            case int s when s <= 6000 -> "Architect Developer";
            default -> "Unknown";
        };

        System.out.println("The employ category is: " + category);

}
}
