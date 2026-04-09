package main.java.com.ModuleFive.commands;
import  main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.service.EmployeeService;


public class ShowUsersCommand implements menuCommand{
    private final EmployeeService service;

    public ShowUsersCommand(EmployeeService service){
        this.service = service;
    }

    @Override
    public void execute(){
        System.out.println("The list of employees is: ");
        //usamos el service para obtener los datos
        var map = service.getMapEmploys();
        for (Integer id : map.keySet()){
        Empleado e = map.get(id);
        System.out.printf("id: %d |Name: %s|Age: %d |Salary: %d|Remote: %b|", id, e.name(), e.age(), e.SalaryByMoth(), e.isRemote() );
    }
}}
