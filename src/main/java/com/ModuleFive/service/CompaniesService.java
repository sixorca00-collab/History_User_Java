package main.java.com.ModuleFive.service;
import main.java.com.ModuleFive.model.Factory;
import java.util.ArrayList;
import java.util.List;


public class CompaniesService {

    private  final List<Factory> factories = new ArrayList<>();

    //Getters
    public List<Factory>getFactories(){
        return factories;
    }
}
