package main.java.com.ModuleFive.commands;

import main.java.com.ModuleFive.model.EmpleadoClass;
import main.java.com.ModuleFive.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

public class CalcularBonoCommand implements menuCommand {

    private final EmployeeService service;

    public CalcularBonoCommand(EmployeeService service) {
        this.service = service;
    }

    @Override
    public Map<String, Double> execute() {

        var empleados = service.getEmployeesClass();
        Map<String, Double> resultado = new HashMap<>();

        if (empleados.isEmpty()) {
            System.out.println("Not employees registered.");
            return resultado;
        }

        for (EmpleadoClass emp : empleados) {

            double bono = emp.CalcularBono();

            resultado.put(emp.getName(), bono);

            emp.registrarOperacion(
                    "Bonus Calculation for: " + emp.getName()
            );
        }

        return resultado;
    }
}