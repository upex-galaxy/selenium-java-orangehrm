package e2e.steps.example;

import org.junit.jupiter.api.*;
public class GabyTest {
    // Declarar variables: una int, un double, dos String
    public static Integer numeroEntero = 7;
    public static double numeroDecimal = 7.5;
    public static String nombre = "Gabriela";
    public static String apellido = "Aro";
    // !Llamar al método PrimerChallenge // para realizar la suma y concatenación
    @Test
    public static void PrimerChallenge(Integer entero, double decimal, String nombre, String apellido) {
        //! Suma de las variables numéricas
        double resultadoSuma = (double) numeroEntero + numeroDecimal;
        //! Concatenar las cadenas de texto
        String nombreCompleto = nombre + " " + apellido;
        //! Imprimir resultados en la consola

        System.out.println("La suma de los números es: " + resultadoSuma);
        System.out.println("El nombre completo es: " + nombreCompleto);
    }   
}


    // public double getNumber(Integer firstNum, double secondNum) {
    // return firstNum + secondNum;
    // }
    //Double resultadoSuma = getNumber(numeroEntero, numeroDecimal);
    //System.out.print(resultadoSuma);
    //PrimerChallenge(numeroEntero, numeroDecimal, nombre, apellido);
    //public static void PrimerChallenge(int entero, float decimal, String nombre, String apellido) {
    //int resultadoSuma = entero + (int) decimal; // Se convierte el float a int para la suma

        