package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.service.EmployeeService;

import java.util.List;
import java.util.Map;

public class TotalPromedioCommand implements menuCommand {
    private final EmployeeService service;

    public TotalPromedioCommand(EmployeeService service){
        this.service = service;
    }
    @Override
    public Map<String, Double> execute(){
        List<Empleado> employees = service.getEmployees();

        if (employees == null || employees.isEmpty()){
            System.out.println("Not employees registered.");
            return null;
        }
        double sum = 0;

        for (Empleado e: employees){
            sum += e.SalaryByMoth();
        }

        var average = sum/employees.size();

        System.out.println("The total salary sum: ");
        System.out.println("Average salary: " + average);

        //Empleado empleado; Asi se accede a los objetos

        return null;
    }
}
