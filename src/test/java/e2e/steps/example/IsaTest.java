package e2e.steps.example;
import org.junit.jupiter.api.*;

public class IsaTest {
    @Test
    public static void ValuesToPrint() {        
        SumNumbers(10, 10.5);
        ConcatenateName("Isabel", "Gonzalez");
    }
    
    public static void SumNumbers(int integerNumber, double doubleNumber){
        Double sumResult = firstNumber + secondNumber;
        System.out.println("The result of the sum is: " + sumResult);
    }

    public static void ConcatenateName(String name, String lastName) {
        String concatenateString = name + " " + lastName;
        System.out.println("The full name is: " + concatenateString);
    }
}
