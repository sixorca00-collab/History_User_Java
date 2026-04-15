package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.service.EmployeeService;
import main.java.com.ModuleFive.model.Empleado;

import java.util.Map;
import java.util.Scanner;

public class createEmployCommand implements menuCommand{
    private final EmployeeService service;
    private final Scanner sc;

    public createEmployCommand(EmployeeService service, Scanner sc){
        this.service = service;
        this.sc = sc;
    }

    @Override
    public Map<String, Double> execute(){

        var id = service.NextId();
        //Pido datos
        System.out.println("Name: ");
        var name = sc.nextLine();

        System.out.println("Give age of the employee: ");
        var age = sc.nextInt();
        sc.nextLine();//Limpiamos buffer.


        System.out.println("¿The employee will work remote?");
        var isRemote = sc.nextBoolean();
        sc.nextLine();

        System.out.println("Give the pay by the employee: ");
        var salaryByMonth = sc.nextLong();
        sc.nextLine();
        Empleado NewEmploy = new Empleado(id, name, age, isRemote, salaryByMonth);

        //De paso lo agregamos al array.
        service.getEmployees().add(NewEmploy);
        service.getMapEmploys().put(id,NewEmploy);

        System.out.printf("Employee registered success. The name is %s he have id: %d.\n", name, id);


        return null;
    }


}
