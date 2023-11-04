package e2e.steps.example;

import org.junit.jupiter.api.*;

public class YeleTest {
    // public static final Integer numA = 20;
    // public static final Integer numB = 50;
    int numA = 20;
    double numB = 0.5;
    String name = "Yelena";
    String last_name = "Martinez";
    /*
     * @Test
     * public void Sumar(Integer numA, Integer numB) {
     * 
     * Integer suma = numA + numB;
     * 
     * System.out.println("La suma es: " + suma);
     * }
     */

    @Test
    public double Sumar(int numA, double numB) {

        double suma = numA + numB;

        System.out.println(suma);
        return suma;

    }

    @Test
    public String Concatenar(String name, String last_name) {

        String concatenado = "name" + "last_name";
        System.out.println(concatenado);
        return concatenado;
    }

}
