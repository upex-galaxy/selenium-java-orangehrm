package e2e.steps.example;

import org.junit.jupiter.api.Test;

public class juanemTest {
    static class FuturoAutomata {
        public String name;
        public int num1;
        public double num2;

        public FuturoAutomata(String name) {
            this.name = name;
            this.num1 = 2;
            this.num2 = 2.5;
        }
    }

    public static String twoNumbers(int num1, double num2){
        double sum = num1 + num2;
        return "Result:" + sum;
    }

    @Test
    public void getResult(){
        FuturoAutomata person = new FuturoAutomata("Juan");
        System.out.println(twoNumbers(person.num1, person.num2));
    }
}
