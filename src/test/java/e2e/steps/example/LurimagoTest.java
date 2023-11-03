package e2e.steps.example;

import org.junit.jupiter.api.*;

public class LurimagoTest {
    // MISSION 1: Sumar variables (int y float)
    // MISSION 2: Concatenar 2 String (Nombre y Apellido) "" + ""

    // Crear un Método para hacer eso.

    // Imprimir los resultados en la Consola con System.out.print

    private Integer numero1 = 5;
    private Double numero2 = 10.5;
    private String cadena1 = "Hola, ";
    private String cadena2 = "mundo!";

    public Double sumNumbers(Integer a, Double b) {
        return a + b;
    }

    public String contactStrings(String cadena1, String cadena2) {
        return cadena1 + cadena2;
    }

    @Test
    public void practicandoGit() {
        double suma = sumNumbers(numero1, numero2);
        String concatenate = contactStrings(cadena1, cadena2);

        System.out.println("La suma es: " + suma);
        System.out.println("La concatenación es: " + concatenate);
    }
}
