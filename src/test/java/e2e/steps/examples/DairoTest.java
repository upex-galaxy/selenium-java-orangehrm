package e2e.steps.examples;

import java.util.Random;

import org.junit.jupiter.api.Test;

// MISSION 1: Sumar 2 variables (Int y Double)
// MISSION 2: Concatenar 2 String (Nombre y Apellido) "" + ""

// Crear un Método para hacer eso.

// Imprimir los resultados en la Consola con System.out.print.

// Guardar cambios, git add, git commit, y git push => y abrir Pull Request.

public class DairoTest { // Mision 1:
    int numeroUno = new Random().nextInt(100);
    double numeroDos = new Random().nextDouble() * 100;
    public static final String nombre = "Dairo";
    public static final String apellido = "Estrada";

    @Test
    public void ShowData() { // Mision 2:
        System.out.print("Hello, Mi nombre es: " + nombre + " " + apellido + ", La suma de los numeros es: " + numeroUno
                + numeroDos
                + ", Aunque se dice que estos numeros NO son \"Aleatorios\", Son Semialeatorios, no existe un numero aleatorio como tal.");
    }

}