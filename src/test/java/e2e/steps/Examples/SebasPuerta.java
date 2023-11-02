package e2e.steps.Examples;

public class SebasPuerta {

    public static double getSum(int num1, double num2) {
        double sumResult = num1 + num2;
        return sumResult;
    }

    public static void getName(String firstname, String lastname) {
        System.out.println("My name is: " + firstname + " " + lastname);
    }

    public static void main(String[] args) {
        int num1 = 5;
        double num2 = 7.5;

        double sum = getSum(num1, num2);
        System.out.println("The result of the sum is: " + sum);

        String firstname = "Sebastian";
        String lastname = "Puerta";

        getName(firstname, lastname);

        System.out.println("¡Saludos UPEX!");
        
    }

}
