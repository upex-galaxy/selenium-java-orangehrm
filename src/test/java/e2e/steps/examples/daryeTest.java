
package e2e.steps.examples;

public class daryeTest {
    public static void main(String[] args) {
        sumarNumeros(42, 56.78);
        nombreCompleto("Daryelin", "Rossell");
    }

    public static void sumarNumeros(int numeroEntero, double numeroFlotante) {
        double suma = numeroEntero + numeroFlotante;
        System.out.println("La suma es: " + suma);
    }

    public static void nombreCompleto(String nombre, String apellido) {
        System.out.println("Mi nombre completo es: " + nombre + " " + apellido);
    }
}
