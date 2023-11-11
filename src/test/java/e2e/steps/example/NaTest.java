package e2e.steps.example;

import org.junit.jupiter.api.*;

public class NaTest {
    @Test
    public void practicandoGit() {
        int n1 = 10;
        double n2 = 20.59;
        String name = "Nathalie";
        String last = "Campos";

        System.out.println("La suma de " + n1 + " mas " + n2 + " es igual a : " + (n1 + n2));
        System.out.println("Estudiante: " + name + " " + last);
    }
}
