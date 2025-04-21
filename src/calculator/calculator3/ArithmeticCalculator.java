package calculator.calculator3;

import java.util.List;

public class ArithmeticCalculator<T extends Number, N extends Number, C extends Character>  {
    // 제네릭 사용하여 자료형 미지의 변수 받아오기
    private T num1;
    private N num2;
    private C char1;
    private double result;

    public ArithmeticCalculator () {
    }

    public void calculate() {
        if (char1.charValue() == '+') {
            result = OperatorType.sum.apply(num1.doubleValue(), num2.doubleValue());
        } else if (char1.charValue() == '-') {
            result = OperatorType.sub.apply(num1.doubleValue(), num2.doubleValue());
        } else if (char1.charValue() == '*') {
            result = OperatorType.mul.apply(num1.doubleValue(), num2.doubleValue());
        } else if (char1.charValue() == '/') {
            try {
                if(num2.doubleValue() != 0)
                    result = OperatorType.div.apply(num1.doubleValue(), num2.doubleValue());
                else
                    throw new ArithmeticException();
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
        }
    }

    public void resultDelete(List<Double> arr) {
        arr.remove(0);
        System.out.println("삭제되었습니다.");
        System.out.println("누적된 계산 결과값 : " + arr);
    }

    public void setNum1(T num1) {
        this.num1 = num1;
    }

    public void setNum2(N num2) {
        this.num2 = num2;
    }

    public void setChar1(C char1) {
        this.char1 = char1;
    }

    public double getResult() {
        return result;
    }

    public void findNums(List<Double> arr, double num3) {
        List<Double> bigNums = arr.stream().filter(num -> num > num3).toList();
        System.out.println("입력값보다 큰 값은 : " + bigNums);
    }

    public void betweenNums(List<Double> arr) {
        List<Double> betweenNums =  arr.stream().filter(num -> num1.doubleValue() < num && num < num2.doubleValue()).toList();
        System.out.println("입력한 두 수 사이에 있는 결과값은 : " + betweenNums);
    }
}
