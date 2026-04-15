package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.service.EmployeeService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class removeEmployByScoreCommand implements menuCommand {
    private final EmployeeService service;
    private final Scanner sc;

    public removeEmployByScoreCommand(EmployeeService service, Scanner sc){
        this.service = service;
        this.sc = sc;
    }
    @Override
    public Map<String, Double> execute(){
        //Obtenemos todos los empleados
        Map<Integer, Empleado> employsMap = service.getMapEmploys();
        List<Empleado> employsList = service.getEmployees();
        if (employsMap == null || employsMap.isEmpty()){
            System.out.println("Not employees registered.");
            return null;
        }

        System.out.println("List of employs:");
        employsMap.forEach((id, emp) -> {
            System.out.println("Id: " + id + " Name: " + emp.name() +"\n");
        });

        //Pedimos el id
        var search = sc.nextInt();
        if(!employsMap.containsKey(search)){
            System.out.println("Employee not found");
            return null;
        }
        //Pedimos Score
        System.out.println("Enter the Score of employ");
        var Score = sc.nextByte();
        sc.nextLine();
        Empleado emp = employsMap.get(search);

        if (Score <= 70){
            employsMap.remove(search);
            employsList.removeIf(e -> e.id() == search);
            System.out.println("Employee discarted: " + emp.name());
        } else {
            System.out.println("Employ aproved: " + emp.name());
        }

        return null;
    }
}
