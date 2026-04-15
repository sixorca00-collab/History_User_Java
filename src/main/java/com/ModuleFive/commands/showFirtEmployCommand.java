package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.service.EmployeeService;

import java.util.List;
import java.util.Map;

public class showFirtEmployCommand implements menuCommand {
    private EmployeeService service;

    public showFirtEmployCommand(EmployeeService service){
        this.service = service;
    }
@Override
    public Map<String, Double> execute(){
        List<Empleado> employees = service.getEmployees();

        if (employees == null || employees.isEmpty()){
            System.out.println("Not employees registered");
            return null;
        }

        Empleado primero = employees.get(0);
        System.out.println("El primer empleado es: \n" + "id: " + primero.id() + " Name: " + primero.name());
    return null;
}
}
