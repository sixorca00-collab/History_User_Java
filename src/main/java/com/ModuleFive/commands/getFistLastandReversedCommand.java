package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.service.EmployeeService;

import java.util.List;

public class getFistLastandReversedCommand implements menuCommand{
    private final EmployeeService service;

    public getFistLastandReversedCommand(EmployeeService service) {
        this.service = service;
    }

    //Ejecutamos bb
    @Override
    public void execute(){
        List<Empleado> employees = service.getEmployees();

        var primero = employees.getFirst();
        var ultimo = employees.getLast();
        var reversed = employees.reversed();

        System.out.println("the first employee registered is: \n" + primero.name());
        System.out.println("the last employee registered is: \n" + ultimo.name());
        System.out.println("The reverse list is: \n" + reversed);
    }
}