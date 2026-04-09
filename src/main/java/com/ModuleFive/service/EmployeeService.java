package main.java.com.ModuleFive.service;
import main.java.com.ModuleFive.model.Empleado;

import java.util.*;

public class EmployeeService {

        private int countId = 1;
        private final List<Empleado> employees = new ArrayList<>();
        private final HashMap<Integer, Empleado> mapEmploys = new HashMap<>();

        //Aumento el ID cada que se cree uno.
        public int NextId(){
            return countId ++;
        }

        //Getters
        public List<Empleado> getEmployees(){
            return employees;
        }
        public HashMap<Integer, Empleado> getMapEmploys(){
            return mapEmploys;
        }



}
