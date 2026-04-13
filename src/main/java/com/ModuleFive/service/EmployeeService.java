package main.java.com.ModuleFive.service;
import main.java.com.ModuleFive.model.Empleado;
import main.java.com.ModuleFive.model.EmpleadoClass;

import java.util.*;

public class EmployeeService {

        private int countId = 1;
        private final List<Empleado> employees = new ArrayList<>();
        private final HashMap<Integer, Empleado> mapEmploys = new HashMap<>();
        private final List<EmpleadoClass> employeesClass = new ArrayList<>();

        //Aumento el ID cada que se cree uno.
        public int NextId(){
            return countId ++;
        }

        //Getters
        public List<Empleado> getEmployees(){
            return employees;
        }
    public List<EmpleadoClass> getEmployeesClass(){
        return employeesClass;
    }
        public HashMap<Integer, Empleado> getMapEmploys(){
            return mapEmploys;
        }



}
