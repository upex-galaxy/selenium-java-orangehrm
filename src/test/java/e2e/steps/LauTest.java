package e2e.steps;

import org.junit.jupiter.api.*;

public class LauTest {
    // MISSION 1: Sumar 2 variables (int y float)
    // MISSION 2: Concatenar 2 String (Nombre y Apellido) "" + ""
    public static final Integer numero1 = 1;
    public static final Double numero2 = 2.2;
    public volatile Double resultado = numero1 + numero2;
    public static final String cadena1 = "Hola ";
    public static final String cadena2 = "Mundo!";

    // Crear un Método para hacer eso.
    // Imprimir los resultados en la Consola con System.out.print.
    @Test
    public void metodo() {
        String s = cadena1 + cadena2;
        Double res = numero1 + numero2;
        System.out.println(s);// Sachin Tendulkar
        System.out.println(res);// Sachin Tendulkar
    }

}
