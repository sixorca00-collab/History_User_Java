package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.service.EmployeeService;

import java.util.List;

public class TotalPromedioCommand {
    private final EmployeeService service;

    public TotalPromedioCommand(EmployeeService service){
        this.service = service;
    }

    public void execute(){
        List<Empleado> employees = service.getEmployees();

        if (employees == null || employees.isEmpty()){
            System.out.println("Not employees registered.");
            return;
        }
        double sum = 0;

        for (Empleado e: employees){
            sum += e.SalaryByMoth();
        }

        var average = sum/employees.size();

        System.out.println("The total salary sum: ");
        System.out.println("Average salary: " + average);

        //Empleado empleado; Asi se accede a los objetos

    }
}
