package e2e.steps.example;
import org.junit.jupiter.api.*;

public class LoreTest {
    public static int numeroEntero = 10; // Variable de tipo int
    public static float numeroDecimal = 3.14f; // Variable de tipo float
    public static float resultado = numeroEntero + numeroDecimal;

    public static final String nombre = "Lorena";
    public static final String apellido = " Tamayo";
    public static final String mostrar = nombre + apellido;

    @Test
    public void muestrate() {
        System.out.println("SUMA =" + resultado);
        System.out.println(mostrar);
    }
}
