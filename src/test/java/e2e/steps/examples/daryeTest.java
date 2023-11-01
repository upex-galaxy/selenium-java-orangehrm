
package e2e.steps.examples;
import org.junit.jupiter.api.*;

public class daryeTest {
    public static final String nombre = "Daryelin";
    public static final String apellido = "Rossell";
    public static final Integer numeroEntero = 42;
    public static final Double numeroFlotante = 56.78;
    
    @Test
    public void miPrimerMetodoJava() {
        System.out.println("Mi nombre completo es: " + nombre + " " + apellido);
        double suma = numeroEntero + numeroFlotante;
        System.out.println("La suma es: " + suma);
    }

}
