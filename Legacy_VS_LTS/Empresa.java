package Legacy_VS_LTS;

import java.time.LocalDate;

public record Empresa(String nombre, int nit, LocalDate fechaCreacion ) {
    public static void main(String[] args) {
        var emp1 = new Empresa("RiwiCorp", 2026666, LocalDate.now());
        System.out.println(emp1); 
    }
}
