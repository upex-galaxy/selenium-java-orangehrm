package e2e.steps.Examples;

import org.junit.Test;

public class DeliaTest {

    String Nombre = "Delia";
    String Apellido = "Cardenas";
    int primer_Numero = 11;
    double Segundo_Numero = 5.34;

    @Test
    public void tarea() {
        System.out.println("Mi nombre completo es " + Nombre + " " + Apellido);
        double suma = primer_Numero + Segundo_Numero;
        System.out.println("el resultado es :" + suma);

    }

}
