package main.java.com.ModuleFive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ExerciseW2 {
    public static void main(String[] args) {

        boolean salir = false;
        String head = """
        *=================================*
        *             MENÚ                *
        *=================================*
        * 1 - Crear Empleado              *
        * 2 - Crear Empresa               *
        * 3 - Definir categoría salarial  *
        * 4 - Mostrar todos los usuarios  *
        * 5- mostrar ultimo empleado      *
        * 6 - Salir                       *
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
                    case 1: CreateUser(sc, empleados );
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
                        lastEmployRegistered(empleados);
                        break;
                    case 6:
                        salir = true;
                        System.out.println("Saliendo...");
                        break;
                    default: System.out.println("Ingrese un número válido porfa.");
                }
            }catch (java.util.InputMismatchException e){
                System.out.println("Asegurese de ingresar el dato que le estan pidiendo.");
                sc.nextLine();
            }



        } while (!salir); // Se repite mientras salir sea false
    }

    //Creo las funciones afuera ya que es mas profesional
    //Inicio los id en cero
     static int  contadorID = 1;
    // inicializo el arrayList
     static ArrayList<Empleado> empleados = new ArrayList<>();
     //Inicializo tambien el HashMap
    static HashMap<Integer, Empleado> mapUser = new HashMap<>();
     static void CreateUser(Scanner sc, ArrayList<Empleado> empleados){
         //Sumamos un numero al id
         var id = contadorID++;
        //Pasamos a capturar datos.
         System.out.println("Ingrese el nombre del empleado: ");
         var name = sc.nextLine();
         //Validamos las entradas con los parametros pedidos en la rubrica
         if (name.isBlank()){
             System.out.println("Por favor rellene el espacio de preferencia con texto.");
             return;
         }

         System.out.println("Ingrese la edad del empleado: ");
         if (!sc.hasNextInt()){
             System.out.println("ingrese un numero porfa");
             return;
         }
         var age = sc.nextInt();
         if (age < 0 || age > 70){
             System.out.println("Ingrese un numero valido por fa");
             return;
         }

         System.out.println("Trabaja remoto? true/false: ");
         var isRemote = sc.nextBoolean();

         System.out.println("Ingrese el salario mensual de este empleado en dolares : ");
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
         System.out.println("El empleado creado tiene los siguientes datos: \n " + "Su id es: "+ id + " Su nombre es: " + NewEmploy.name() + " Y tiene: " + NewEmploy.age() + " años" + " Trabaja remoto? " + NewEmploy.isRemote() + " Y su salario mensual asignado fue: " + NewEmploy.SalaryByMoth() + "$ dolares" );
    }


    //Pasamos a crear empresa
    static void CreateFactory(Scanner sc){
        //Pasamos a capturar datos.
        System.out.println("Ingrese el nombre de la empresa: ");
        var nameCompany = sc.nextLine();

        System.out.println("Ingrese la cantidad de sedes que tiene la empresa: ");
        var sedes = sc.nextByte();
        sc.nextLine();

        System.out.println("En que area esta especializada la empresa: ");
        var area = sc.nextLine();

        // Insertamos datos usando el record.
        Factory newFactory = new Factory(nameCompany, sedes, area);
        //Mostramos por consola lo ingresado.
        System.out.println("La empresa ingresada fue: "+ newFactory.nameCompany() + " con " + newFactory.sedes() + " Sedes" + " Y dedicada a: " + newFactory.area());

    }

    static void calcularCategoriaSalarial(Scanner sc) {
        System.out.println("cuanto gana el fulano a evaluar: ");
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
        System.out.println("El salario ingresado: " + salary + " Corresponde a la categoria de: " + category);

    }
    static void showEmploys(HashMap<Integer, Empleado> mapUser) {
        System.out.println("La lista de todos los empleados es: ");
        for (Integer id: mapUser.keySet()){
            Empleado e =mapUser.get(id);
            System.out.println("id: " + id + " name: " + e.name() + " age: " + e.age() + " salary: " + e.SalaryByMoth() + " work remote: " + e.isRemote());
        }
        }

    static void lastEmployRegistered(ArrayList<Empleado> empleados){
        if (empleados != null && !empleados.isEmpty()) {
            // obtengo el ultimo elemento
            Empleado lastEmploy = empleados.get(empleados.size() - 1);
            System.out.println("Last employee: " + lastEmploy);
        } else {
            System.out.println("No employees registered.");
        }
    }
}

