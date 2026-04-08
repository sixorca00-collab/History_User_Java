package main.java.com.ModuleFive;

import java.util.*;

public class ExerciseW2 {
    public static void main(String[] args) {

        boolean exit = false;
        String head = """
*==================================================*
*                   MENÚ                           *
*==================================================*
* 1 - Create Employ                                *
* 2 - Create Company                               *
* 3 - Define salary category                       *
* 4 - Show all users                               *
* 5 - Show last employed                           *
* 6 - Show first employed                          *
* 7 - Remove user by ID                            *
* 8 - Show first & last employee + reversed list   *
* 9 - Remove employ by Score                       *
* 10-total number of employees and average salary  *
* 11-Exit                                          *
*==================================================*
""";
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
                        removeEmploybyId(sc,  employs,  mapUser);
                        break;
                    case 8:
                        getFirstAndLastEmploy(LinkedEmploys);
                    case 9:
                        removeEmployByScore( sc, mapUser);
                        break;
                    case 10:
                        totalPromedio(employs);
                    case 11:
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
    //==========================================================================================================================
    //==========================================================================================================================
    //==========================================================================================================================
    //Creo las funciones afuera ya que es mas profesional
    //Inicio los id en cero
     static int  countID = 1;
    // inicializo el arrayList
     static ArrayList<Empleado> employs = new ArrayList<>();
     //Inicializo tambien el HashMap
    static HashMap<Integer, Empleado> mapUser = new HashMap<>();
    //uso LinkedList implementado en Java 21 para poder usar getFirst,Last y reversed.
    static LinkedList<Empleado> LinkedEmploys = new LinkedList<>();
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
        /*
         * List.of() y Map.of() garantizan inmutabilidad. A diferencia de ArrayList,
         * no permiten cambios post-creación, lo que previene errores de estado
         * inconsistente en el objeto 'newFactory'.
         */
        //Pasamos a capturar datos.
        System.out.println("Give the name company: ");
        var nameCompany = sc.nextLine();

        System.out.println("Enter the number of locations the company has: ");
        var sedes = sc.nextByte();
        sc.nextLine();


        System.out.println("Enter the Main specialize in your factory");
        var area = sc.nextLine();
        System.out.println("Enter the technologies that the company has(Max 3)");
        //Capturamos los datos que iran al List
        System.out.println("Enter area 1:");
        var t1 = sc.nextLine();
        System.out.println("Enter area 2:");
        var t2 = sc.nextLine();
        System.out.println("Enter area 3:");
        var t3 = sc.nextLine();
        //Se agregan a la List con List.of
        List<String> tecnologias = List.of(t1, t2, t3);
        //Capturo los datos que iran al Map.
        System.out.println("Enter the 2 main locations");
        //Clave - valor
        System.out.println("Get the area:");
        var area1 = sc.nextLine();
        System.out.println("Get the location");
        var location1 = sc.nextLine();
        //====================================
        //2da sede
        System.out.println("get the area 2: ");
        var area2 = sc.nextLine();
        System.out.println("get the location of area 2: ");
        var location2 = sc.nextLine();

        Map<String, String> ubicacion = Map.of(area1,location1, area2, location2);

        // Insertamos datos usando el record.
        Factory newFactory = new Factory(nameCompany, sedes, area, tecnologias, ubicacion);

        // --- RETORNO VISUAL (RECIBO) ---
        System.out.println("\n==========================================");
        System.out.println("           OFFICIAL RECEIPT              ");
        System.out.println("==========================================");
        System.out.println("COMPANY:      " + newFactory.nameCompany().toUpperCase());
        System.out.println("BRANCHES:     " + newFactory.sedes());
        System.out.println("SECTOR:       " + newFactory.area());
        System.out.println("------------------------------------------");
        System.out.println("TECHNOLOGIES: " + String.join(" | ", newFactory.tecnologias()));

        // Corregido: .ubicacion() con el cierre de paréntesis del println
        System.out.println("LOCATIONS:    " + newFactory.sedesDetalle());

        System.out.println("------------------------------------------");
        System.out.println("STATUS:       Verified & Immutable (Java 11)");
        System.out.println("==========================================\n");

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
    static void removeEmploybyId(Scanner sc, ArrayList<Empleado> employs, HashMap<Integer, Empleado> mapUser){

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
    static void getFirstAndLastEmploy(List<Empleado> employs){
        if(employs != null && !employs.isEmpty()){
            //Convierto la ArrayList a LinkedList
            LinkedList<Empleado> linkedEmploys = new LinkedList<>(employs);

            var firstEmploy = linkedEmploys.getFirst();
            var lastEmploy = linkedEmploys.getLast();
            var reverseList = linkedEmploys.reversed();

            System.out.println("The first employ registered is: " + firstEmploy);
            System.out.println("The last employ registered is:  " + lastEmploy);
            System.out.println("The list the employs in reverse is: " + reverseList);
        }
    }
    static void removeEmployByScore( Scanner sc, HashMap<Integer, Empleado> mapUser){
         //Los llamo para ver
        try {
            showEmploys(mapUser);
            System.out.println("¿What is the employ id?");
            var id = sc.nextInt();
            sc.nextLine();
            var existe = mapUser.containsKey(id);
            if (!existe){
                System.out.println("the employ not exist.");
                return;
            }else {
                System.out.println("The emply this" + mapUser.get(id));
            }

            System.out.println("¿What score did the user get?(limit 100)");
            var score = sc.nextByte();
            sc.nextLine(); //limpio ya que se pidio dato numerico.
            if(score <0 || score >100){
                System.out.println("Get a valid number");
            } else if  (score <= 50) {
                mapUser.entrySet().removeIf(entry -> entry.getKey().equals(id)); //removeIf
                System.out.println("The employee was dismissed for failing the test");
            }else {
                System.out.println("The employ pass a test");
            }
        } catch ( InputMismatchException e) {
            System.out.println("Get a valid data");
            sc.nextLine();
        }
    }
    /*
     En este programa se utilizó inferencia de tipos mediante la palabra clave `var`,
     introducida en Java 10 y ampliamente usada en Java 11+.

      Esto permite declarar variables locales sin especificar explícitamente su tipo,
     ya que el compilador lo infiere automáticamente a partir del valor asignado.

     Ejemplo comparativo:

     Java 8 (declaración explícita):
         Integer id = sc.nextInt();
        Empleado emp = mapUser.get(id);

     Java 11+ (inferencia de tipos):
       var id = sc.nextInt();
       var emp = mapUser.get(id);

     Ventajas:
      - Reduce la redundancia en el código.
      - Mejora la legibilidad cuando el tipo es evidente.
      - Hace el código más limpio y moderno.

      Además, `var` se utilizó en:
      - Variables locales dentro de métodos
      - Bucles for-each
      - Expresiones lambda (removeIf)

      Restricciones importantes:
      - No se puede usar en atributos de clase
      - No se puede usar como tipo de retorno
      - Solo aplica a variables locales

      Con esto, el código demuestra el uso moderno de Java,
      manteniendo claridad sin sacrificar el tipado fuerte del lenguaje.
     */
    static void totalPromedio(ArrayList<Empleado> employs){
        if (employs == null || employs.isEmpty()){
            System.out.println("Not employees registered");
            return;
        }
        var totalEmploys = employs.size();
            System.out.println("total employs: " + totalEmploys);


            System.out.println("The average of all salaries is: ");
            var suma = 0L;

            for (var emp : employs){
                suma += emp.SalaryByMoth();
            }
            var promedio = suma/totalEmploys;

            System.out.println("The average of the all salaries is: " + promedio);




    }
}


