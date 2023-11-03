package e2e.steps.example;

import org.junit.jupiter.api.*;

public class OrianaTest {
    public static final String name = "Oriana";
    public static final String lastname = "Palma";
    public static final Integer number1 = 50;
    public static final Double number2 = 50.50;

    @Test
    public void javaPrimerMetodo() {
        System.out.println("mi nombre es:" + name + " " + lastname);
        Double sumaNumeros = number1 + number2;
        System.out.println("la suma de los numeros es" + " " + sumaNumeros);
        Double restaNumeros = number2 - number1;
        System.out.println("la resta de los numeros es" + " " + restaNumeros);
    }
}
