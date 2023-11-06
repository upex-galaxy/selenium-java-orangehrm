// Sumar 2 variables (Int y Double)
// Concatenar 2 String (nombre y apellido)
// Crear un Método para hacer eso.
// Imprimir los resultados en la Consola con System.out.print.
// Guardar cambios, git add, git commit, y git push => y abrir Pull Request.

package e2e.steps.example;
import org.junit.jupiter.api.*;
import java.util.Random;
import org.junit.Test;

public class IsaTest {
    private static final String[] names = {"Isabel", "Emily", "Jamie", "David", "Alexander"};
    private static final String[] lastNames = {"Gonzalez", "Gil", "Flores", "Gomez", "Perez"};

    @Test
    public void testPrintSumNumbers() {
        int integerNumber = new Random().nextInt(100);
        double doubleNumber = new Random().nextDouble() * 100;

        Double sumResult = SumNumbers(integerNumber, doubleNumber); //call the method and get the result
        System.out.println("The result of the sum is: " + sumResult);
    }

    @Test
    public void testPrintConcatenateName() {
        String name = names[new Random().nextInt(names.length)];
        String lastName = lastNames[new Random().nextInt(lastNames.length)];

        String concatenateString = ConcatenateName(name, lastName); //call the method and get the result
        System.out.println("The full name is: " + concatenateString);
    }

    public Double SumNumbers(int integerNumber, double doubleNumber) {
        return integerNumber + doubleNumber;
    }

    public String ConcatenateName(String name, String lastName) {
        return name + " " + lastName;
    }
}