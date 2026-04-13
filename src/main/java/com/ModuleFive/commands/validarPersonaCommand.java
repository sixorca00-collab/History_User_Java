package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.model.*;
import main.java.com.ModuleFive.service.EmployeeService;

import java.util.List;

public class validarPersonaCommand {
    EmployeeService service;
    public validarPersonaCommand(EmployeeService service){
        this.service = service;
    }

    public void execute(){

        List<EmpleadoClass> empleados = service.getEmployeesClass();

        if (empleados == null || empleados.isEmpty()) {
            System.out.println("No hay empleados");
            return;
        }

        for (EmpleadoClass p : empleados) {

            if (p instanceof Desarrollador d) {
                System.out.println("language: " + d.getLenguajePrincipal());

            } else if (p instanceof Gerente g) {
                System.out.println("budget: " + g.getPresupuestoMensual());

            } else {
                System.out.println("Type not identified");
            }
        }
    }
}
