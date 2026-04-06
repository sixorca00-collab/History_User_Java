package main.java.com.ModuleFive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ExerciseW2 {
    public static void main(String[] args) {

        boolean exit = false;
        String head = """
        *=================================*
        *             MENÚ                *
        *=================================*
        * 1 - Create Employ              *
        * 2 - Create Company               *
        * 3 - Define salary category  *
        * 4 - Get all users       *
        * 5- Show last employed      
        * 6 -show first employed
        * 7 - remove user by Id
        * 8 - Exit           *
        *=================================*""";
        //System.out.println(head); Hice un encabezado aprovechando el TextBlock.

        Scanner sc = new Scanner(System.in);

        do {
            // Mostramos el menú
            System.out.println(head);

            // Control del menú
            try {

                // Leemos la opción del usuario
                byte option = sc.nextByte();
                sc.nextLine(); // Limpiamos buffer

                switch (option) {
                    case 1: CreateUser(sc, employs );
                        break;
                    case 2: CreateFactory(sc);
                        break;
                    case 3: calcularCategoriaSalarial(sc);
                        break;
                /*En resumen el break es para definir que pare, si no ejecutara todos los demas casos de ahi para abajo,
                haciendo mas de lo que se pidio y en caso de que sea algo muy largo o tenga bucles podria hasta dañar el programa o saturar, el punto es
                que olvidar un break era algo horrible/ el lugar donde uso el nuevo switch explico porque es mejor y mas breve.*/
                    case 4:
                        showEmploys(mapUser);
                        break;
                    case 5:
                        lastEmployRegistered(employs);
                        break;
                    case 6:
                        firtsEmployRegistered(employs);
                        break;
                    case 7:
                        removeEmploy(sc,  employs,  mapUser);
                        break;
                    case 8:
                        exit = true;
                        System.out.println("Leaving...");
                        break;
                    default: System.out.println("Give a number valid please.");
                }
            }catch (java.util.InputMismatchException e){
                System.out.println("Make sure you enter valid information");
                sc.nextLine();
            }



        } while (!exit); // Se repite mientras salir sea false
    }

    //Creo las funciones afuera ya que es mas profesional
    //Inicio los id en cero
     static int  countID = 1;
    // inicializo el arrayList
     static ArrayList<Empleado> employs = new ArrayList<>();
     //Inicializo tambien el HashMap
    static HashMap<Integer, Empleado> mapUser = new HashMap<>();
     static void CreateUser(Scanner sc, ArrayList<Empleado> empleados){
         //Sumamos un numero al id
         var id = countID++;
        //Pasamos a capturar datos.
         System.out.println("Give the name to employ: ");
         var name = sc.nextLine();
         //Validamos las entradas con los parametros pedidos en la rubrica
         if (name.isBlank()){
             System.out.println("Please fill the field.");
             return;
         }

         System.out.println("Give the age of the employ: ");
         if (!sc.hasNextInt()){
             System.out.println("Give a number please");
             return;
         }
         var age = sc.nextInt();
         sc.nextLine();
         if (age < 0 || age > 70){
             System.out.println("Get a number valid please");
             return;
         }

         System.out.println("¿Remote work? Y/N: ");
         String input = sc.nextLine();
         boolean isRemote = input.equalsIgnoreCase("Y"); //True si es Y cualquier otro valor false.

         System.out.println("Give the monthly salary: ");
         var salary = sc.nextLong();

         //Insertamos los datos en el record.
         Empleado NewEmploy = new Empleado(id, name,age,isRemote,salary);
         //Lo inserto en la arrayList.
         empleados.add(NewEmploy);
         //De paso en el HashMap dejando el id como clave y el Empleado como valor

         mapUser.put(id, NewEmploy);


         // Mostramos los datos y el empleado.
         //System.out.println("Testeo de ingresar en la ArrayList");
         //System.out.println(empleados);

         //System.out.println("Testeo de ingresar en el HashMap");
         //System.out.println(mapUser);
         System.out.println("The created employee has the following data: \n"
                 + "Their ID is: " + id
                 + " Their name is: " + NewEmploy.name()
                 + " and they are: " + NewEmploy.age() + " years old"
                 + " Works remotely? " + NewEmploy.isRemote()
                 + " And their assigned monthly salary is: " + NewEmploy.SalaryByMoth() + " dollars");
    }

    //Pasamos a crear empresa
    static void CreateFactory(Scanner sc){
        //Pasamos a capturar datos.
        System.out.println("Give the name company: ");
        var nameCompany = sc.nextLine();

        System.out.println("Enter the number of locations the company has: ");
        var sedes = sc.nextByte();
        sc.nextLine();

        System.out.println("¿In what area does the company specialize?");
        var area = sc.nextLine();

        // Insertamos datos usando el record.
        Factory newFactory = new Factory(nameCompany, sedes, area);
        //Mostramos por consola lo ingresado.
        System.out.println("The entered company is: " + newFactory.nameCompany()
                + " with " + newFactory.sedes() + " branches"
                + " and dedicated to: " + newFactory.area());

    }

    static void calcularCategoriaSalarial(Scanner sc) {
        System.out.println("Enter the salary of the employee to be evaluated:");
        var salary = sc.nextInt();
        sc.nextLine();
        String category = switch (salary){
            case int s when s <= 1000 -> "Junior Developer";
            case int s when s <= 2500 -> "Mid developer";
            case int s when s <= 3000 -> "Senior Developer";
            case int s when s <= 6000 -> "Arquitect Developer";
            /*En este caso el nuevo switch es mejor ya que es mas breve de escribir y toma cada case como un caso independiente
             cada case -> es una expresion diferente y java con esto no permite caida en cascada y el fall-trough era un problema muy comun
             en el anterior al olvidar un break ejecutaba lo demas sin parar*/

            default -> throw new IllegalStateException("Unexpected value: " + salary);
        };
        System.out.println("The entered salary: " + salary + " corresponds to the category: " + category);

    }
    static void showEmploys(HashMap<Integer, Empleado> mapUser) {
        System.out.println("The list of all employees is:");
        for (Integer id: mapUser.keySet()){
            Empleado e =mapUser.get(id);
            System.out.println("id: " + id + " name: " + e.name() + " age: " + e.age() + " salary: " + e.SalaryByMoth() + " work remote: " + e.isRemote());
        }
        }
    static void removeEmploy(Scanner sc, ArrayList<Empleado> employs, HashMap<Integer, Empleado> mapUser){

        System.out.println("Enter the ID you want to remove:");

        // validar ANTES de leer
        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID.");
            sc.nextLine(); // limpiar buffer
            return;
        }

        int search = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        //  verificar si existe
        if (!mapUser.containsKey(search)) {
            System.out.println("Employee not found.");
            return;
        }

        // eliminar de ambas estructuras
        mapUser.remove(search);
        employs.removeIf(emp -> emp.id() == search);

        System.out.println("Employee removed successfully.");
    }


    static void lastEmployRegistered(ArrayList<Empleado> employs){
        if (employs != null && !employs.isEmpty()) {
            // obtengo el ultimo elemento
            Empleado lastEmploy = employs.get(employs.size() - 1);
            System.out.println("Last employee: " + lastEmploy);
        } else {
            System.out.println("No employees registered.");
        }
    }
    static void firtsEmployRegistered(ArrayList<Empleado> employs) {
            if (employs != null && !employs.isEmpty()) {
                // obtengo el indice 0.
                Empleado firstEmploy = employs.get(0);
                System.out.println("First employee: " + firstEmploy);
            } else {
                System.out.println("No employees registered.");
            }
        }
}


