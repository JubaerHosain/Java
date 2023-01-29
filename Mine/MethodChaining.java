// Method chaining is not thread safe in java

public class Calculator {
    private int result;

    public Calculator add(int number) {
        result += number;
        return this;
    }

    public Calculator subtract(int number) {
        result -= number;
        return this;
    }

    public int getResult() {
        return result;
    }
    
    
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(10).subtract(5).add(2);
        System.out.println(calculator.getResult()); // Outputs: 7
    }
}

