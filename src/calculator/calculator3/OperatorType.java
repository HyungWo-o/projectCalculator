package calculator.calculator3;

public enum OperatorType {
    //enum 상수 정의
    sum, sub, mul, div;

    public double apply(double num1, double num2) {
        if(this.equals(sum)) {
            return num1 + num2;
        } else if (this.equals(sub)){
            return num1 - num2;
        } else if (this.equals(mul)){
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }

}
