package calculator.calculator2;

public class Calculator {

    int num1;
    int num2;
    char char1;
    int result;

    public Calculator (int num1, int num2, char char1) {
        this.num1 = num1;
        this.num2 = num2;
        this.char1 = char1;
    }

    public int sum() {
        result = num1 + num2;
        return result;
    }

    public int sub() {
        result = num1 - num2;
        return result;
    }

    public int mul() {
        result = num1 * num2;
        return result;
    }

    public int div() {
        result = num1 / num2;
        return result;
    }
}
