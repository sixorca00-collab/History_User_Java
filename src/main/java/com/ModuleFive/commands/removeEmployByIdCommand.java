package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.service.EmployeeService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class removeEmployByIdCommand implements menuCommand {
    private final EmployeeService service;
    private final Scanner sc;

    public removeEmployByIdCommand(EmployeeService service, Scanner sc){
        this.service = service;
        this.sc = sc;
    }
@Override
    public void execute(){
        Map<Integer, Empleado> employsMap = service.getMapEmploys();
        List<Empleado> employsList = service.getEmployees();

        //Ahora si lo riquito
        if (employsMap == null || employsMap.isEmpty()){
            System.out.println("Not employees registered");
            return;
        }
        System.out.println("employs whit id: ");
        System.out.println(employsMap);

        //Pedimos el id que va a evaluar
        System.out.println("Which employee id you going to eliminate?");
        var remove = sc.nextInt();
        sc.nextLine();

        if (!employsMap.containsKey(remove)){
            System.out.println("Employ not found");
            return;
        } Empleado removed = employsMap.remove(remove);
          employsList.removeIf(e -> e.id() == remove);
        System.out.println("The employ deleted is:\n " + removed.name());
        }

    }

