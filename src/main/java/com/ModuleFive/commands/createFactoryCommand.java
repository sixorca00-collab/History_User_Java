package main.java.com.ModuleFive.commands;
import main.java.com.ModuleFive.service.CompaniesService;
import main.java.com.ModuleFive.model.Factory;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class createFactoryCommand implements menuCommand {
    private final Scanner sc;
    private final CompaniesService service;

    public createFactoryCommand(Scanner sc, CompaniesService service){
        this.sc = sc;
        this.service = service;
    }

    public Map<String, Double> execute(){
        Scanner sc = new Scanner(System.in);
        //Pido los datos
        System.out.println("Give the company name: ");
        var nameCo = sc.nextLine();

        System.out.println("How many locations does the company have?");
        var locations = sc.nextByte();
        sc.nextLine();

        System.out.println("Enter the main area in which you work");
        var mainArea =  sc.nextLine();

        System.out.println("Enter the technologies your company uses (minimum 3). ");
        System.out.println("What is the first area: ");
        var tech1 = sc.nextLine();
        System.out.println("What is second area: ");
        var tech2 = sc.nextLine();
        System.out.println("What is a third area: ");
        var tech3 = sc.nextLine();

        //Creo un Listof para poder meterlo al NewCompany
        List<String> technologies = List.of(tech1, tech2, tech3);

        System.out.println("Enter the 2 main locations with their address.(Min 1)");
        System.out.println("Enter the Main location");
        var loc1 = sc.nextLine();
        System.out.println("Enter the address by location");
        var addr1 = sc.nextLine();
        System.out.println("Optional: Enter the second location.");
        var loc2 = sc.nextLine();
        System.out.println("Enter the address: ");
        var addr2 = sc.nextLine();
        //Hago el map para relacionar la location con la address
        Map<String, String> Locations = Map.of(loc1,addr1,loc2,addr2);

        //Instancio el objeto empresa-company

    Factory NewCompany = new Factory(nameCo, locations, mainArea, technologies, Locations);

        //Una vez instanciado lo llevo a los arrays.
        service.getFactories().add(NewCompany);
        System.out.printf("The company has created the name is: %s and have %d locations\n", nameCo, locations);


        return null;
    }
}
