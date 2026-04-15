package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.service.EmployeeService;

import java.util.List;
import java.util.Map;

public class showLastUserCommand implements menuCommand{
    private EmployeeService service;

    public showLastUserCommand(EmployeeService service){
        this.service = service;
    }
@Override
    public Map<String, Double> execute(){
        List<Empleado> employees = service.getEmployees();
        if (employees == null || employees.isEmpty()){
            System.out.println("Not employees registered");
            return null;
        }
        Empleado ultimo = employees.get(employees.size()-1);

        System.out.println("Last employ:\n " + " id:" + ultimo.id()+ " Name: " + ultimo.name() );
    return null;
}
}
