package e2e.steps.examples;

public class RodrigoTest {

    public double resultadoSuma(int n1, double n2){
       double mision1 = n1 + n2;
       return mision1;
    }

    public String concatName(String firstName, String lastName){
       String mision2 = firstName + lastName;
       return mision2;
    }

    public static void main(String[] args) {

        RodrigoTest rodrigoTest = new RodrigoTest();

        int entero = 5;
        double decimal = 3.14;

        String nombre = "Rodrigo ";
        String apellido = "Castiblanco";


        double resultado = rodrigoTest.resultadoSuma(entero, decimal);
        System.out.println("El resultado de la suma es: " + resultado);

        String fullName = rodrigoTest.concatName(nombre, apellido);
        System.out.println("Mi nombre es: " + fullName );

    }

}
