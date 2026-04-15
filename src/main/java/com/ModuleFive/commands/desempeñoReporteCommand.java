package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.model.desempeñoRecord;
import main.java.com.ModuleFive.service.EmployeeService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class desempeñoReporteCommand implements menuCommand{
    private EmployeeService service;
    private Scanner sc;
    public desempeñoReporteCommand(  EmployeeService service, Scanner sc){
        this.service = service;
        this.sc = sc;
    }

@Override
    public Map<String, Double> execute(){
        List<Empleado> empleados = service.getEmployees();
        System.out.println(empleados);
        System.out.println("Enter the employ id: ");
        var idEmployee = sc.nextInt();
        System.out.println("Enter the employee's monthly performance: ");
        var performance = sc.nextDouble(); sc.nextLine();
        System.out.println("Enter your feedback: ");
        var feedback = sc.nextLine();

        //Hago el constructor del record.
        desempeñoRecord performanceMonthly = new desempeñoRecord(idEmployee, performance, feedback);

       Empleado empleadoEncontrado = empleados.stream()
            .filter(e -> e.id() == idEmployee)
            .findFirst()
            .orElse(null);

    if (empleadoEncontrado != null) {
        System.out.println("The employee evaluated was: " + empleadoEncontrado.name());
    } else {
        System.out.println("Employee not found");
    }
    return null;
}
    }
