package e2e.steps.example;

import org.junit.jupiter.api.*;

public class LorenaTest {

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

    // 0.- creo el archivo.java y una clase
    // 1.- creo las variables
    private Integer uno = 55;
    private Double dos = 60.5;

    // 2.-creo la funcion: ojo puede ser otro nombre dentro del (),
    // pero debe ser el mismo dato: Integer, Double que el paso 1
    // con return sacamos fuera los valores para la llamada

    public Double getNumber(Integer entero, Double decimal) {
        return entero + decimal;
    }
    // 3.-
    // importamos el paquete sobre la clase dl paso 0: import
    // org.junit.jupiter.api.*;
    // @test llamamos
    // creamos una funcion() vacia
    // creamos una variable en donde llamamos a la funcion paso 2
    // con los valores de las variables del paso 1
    // imprimimos variable

    @Test
    public void practicandoGit() {

        Double magia = getNumber(uno, dos);
        System.out.println(magia);
    }

}
