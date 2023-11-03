
// MISSION 1: Sumar 2 variables (int y float)
// MISSION 2: Concatenar 2 String (Nombre y Apellido) "" + ""
// Crear un Método para hacer eso.
// Imprimir los resultados en la Consola con System.out.print.

package e2e.steps.example;

import org.junit.jupiter.api.*;

public class JoseTest {

    private Integer test = 5;
    private Double test2 = 5.5;
    private String nombre = "jose";
    private String apellido = "Roa";

    public Double getNumber(Integer firstNum, Double secondNum) {
        return firstNum + secondNum;
    }

    @Test
    public void practicandoGit() {
        String prueba = (nombre + " " + apellido);
        Double resultado = getNumber(test, test2);
        System.out.println("el resultado es: " + resultado);
        System.out.println("mi nombre es: " + prueba);
    }

    // public String nombreDelUsuario(String nombreMio, String apellidoMio) {
    // return nombreMio + " " + apellidoMio;
    // }

    public void jugandoConMiNombre() {
        String prueba = (nombre + " " + apellido);
        System.out.println("mi nombre es: " + prueba);

    }

}
