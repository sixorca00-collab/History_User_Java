package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.service.EmployeeService;

import java.util.List;

public class showLastUserCommand {
    private EmployeeService service;

    public showLastUserCommand(EmployeeService service){
        this.service = service;
    }

    public void execute(){
        List<Empleado> employees = service.getEmployees();
        if (employees == null || employees.isEmpty()){
            System.out.println("Not employees registered");
            return;
        }
        Empleado ultimo = employees.get(employees.size()-1);

        System.out.println("Last employ:\n " + " id:" + ultimo.id()+ " Name: " + ultimo.name() );
    }
}
