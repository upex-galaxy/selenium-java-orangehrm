package e2e.steps.example;

import org.junit.jupiter.api.Test;

public class EriTest {

    public static void sumarNúmeros(int entero, double flotante) {
        double suma = entero + flotante;
        System.out.println("La suma es: " + suma);
    }

    public static void nombreCompleto(String nombre, String apellido) {
        System.out.println("El nombre completo es: " + nombre + " " + apellido);
    }

    @Test
    public void obtenerVariables() {
        sumarNúmeros(50, 40.70);
        nombreCompleto("Erika", "Tolosa");
    }
}
