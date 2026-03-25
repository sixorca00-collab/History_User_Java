public class NotasArquitectura {
    public static void main(String[] args) { //TASK 1
        /*Java 8 =  Se dice que Java 8 es el renacimiento de Java, incluso que es el nacimiento de "Java moderno".
        Java deja el sistema tosco que tenia y pasa a ser mas funcional sin olvidar la POO, se establece un lenguaje mas "amigable" con el programador
        fuera de eso antes Java era como tener que construir toda la maquina para un solo boton, un infierno para testeadores e incluso el mismo desarrollador,
        Esto con ayuda de Lambdas()
        Streams(),
        Se corrigio el famoso NullPointerException, ya que antes de esto, ningun valor null podia modelarse.
        
        Java 9-11= Sistema de modulos(Project Jigsaw)
        En esta se definio que partes del codigo eran visibles, cuales no, control de dependencias pasa de ser un monton de codigo "abierto" a uno modular
        encapsulado y organizado a gran escala solucionando conflictos entre librerias, dependencias ocultas y la JSHELL que permitio ejecutar el codigo
        sin ejecutar clases completas.
        inferencia de tipos(VAR) que permitia al compilador ayudarte, apoyarte de el sin eliminar el tipado fuerte, y optimizaba ya que no habia que escribir tanto
        
        Luego en Java 11 trajeron LTS()
        que fue una version a largo plazo que puso HTTP moderno, mejoras de rendimiento, limpieza de API'S antiguas. Aqui Java construyo los pilares para volverse
        backend moderno.
        
        De Java 12 a 17 se enfocaron a volver el codigo mas corto, claro y dificil de romper.
        cambian los Switchs y añaden los textBlocks para fusionarse mejor con SQL, JSON y HTML.
        
        Java 16 es de las mas importantes porque cambio datos de comportamiento, antes era muy repetitivo. Despues eso se generaba casi que automaticamente.
        La paternidad paso a poder trabajar con conjuntos de manera mas agil y rapida.
        SealedClases permiten tener mayor control sobre las herencias
        
        Java 17 se enfoca en volverse una base solida con mejor desarrollo, rendimiento y lenguaje mas expresivo.
        
        Java 18-21
        Se cambia el modo de Threads(hilos) por virtual Threads para ya que los hilos normales consumian espacio en memoria, eran toscos y pues podian variar segun el sistema 
        operativo. Mientras que los virtuales eran mas ligero, lo otro es la Structure Concurrency: permitio organizar las tareas de modo que fueran mas faciles de seguir con 
        un flujo mas claro y mayor control.

        El bytecode es un Lenguaje muy bajo, tanto que nisiquiera humanos pueden hacerlo. Por eso se creo la JVM(para transformar codigo normal a Bytecode y optimizar los procesos)
        Adentrandonos mas a profundidad hay conceptos interesantes como el JIT(Just in Time): que entrega los recursos necesarios cuando se piden y en la cantidad requerida
        su idea es reducir al maximo lo innecesario, eliminar desperdicios, mejorando la eficiencia operativa.

        Garbage collector(Limpieza automatica).
        Se creo porque Java maneja objetos, la cosa es que en determinado punto el programa deja de usarlos y esos objetos quedaban ahi, saturando el flujo.
        Hasta que el programa colapsaba, por consiguiente se crea el Garbage collector para limpiar, y liquidar objetos que ya no son usados.
        
        ¿Cómo se organiza la memoria (Heap)?
        Se divide en 3: Eden(Generacion joven), SurvivorSpaces, Old Generation(Generacion vieja).
        
        En eden nacen todos los objetos, es como una fiesta, muy concurrida

        en survivorSpaces: quedan todos los que sobreviven a la limpieza de el Eden, como una lista de espera para ir al paso que siguen

        Old Generation: Si un objeto sobrevive a muchas limpiezas se muda aqui, ya que son estables, pueden ir configuraciones, cookies 
        
        ¿Cómo ha cambiado con el tiempo?
        Antiguamente el Collector, Detenia el programa"Stop the world" para limpiar y gestionar la memoria
        con el tiempo se fue optimizando

        Serial GC: Una sola persona con una escoba. Barata pero lenta.

        Parallel GC: Un equipo de limpieza trabajando a la vez. Muy eficiente para procesar muchos datos, pero aún detiene el mundo un poco.

        G1 (Garbage First): El estándar moderno. Divide la memoria en cuadritos pequeños y limpia primero los que tienen más basura. Es mucho más fluido.

        ZGC y Shenandoah (Lo más nuevo): Son como robots ninja. Limpian la memoria mientras tu aplicación sigue corriendo. Los tiempos de pausa son casi imperceptibles
        (menos de 1 milisegundo), sin importar si tienes 1 GB o 16 TB de RAM.

        la JVM, No solo transforma tu codigo, si no que lo vigila haciendo que sea optimo, ya que no tienes que estar pendiente de absolutamente todo. Como pedir un vaso de agua y tener 
        que cerrar el agua de toda la casa manualmente, es una herramienta que nos ayuda a no hacer el trabajo tan tedioso.
        */
    }
}
