package calculator.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private int num1;
    private int num2;
    private char char1;
    private int result;

    public Calculator () {
    }

    public void calculator() {
        if (char1 == '+') {
            result = num1 + num2;
        } else if (char1 == '-') {
            result = num1 - num2;
        } else if (char1 == '*') {
            result = num1 * num2;
        } else if (char1 == '/') {
            try {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
        }
    }

    public List<Integer> resultDelete(List<Integer> arr) {
        arr.remove(0);
        System.out.println("삭제되었습니다.");
        return arr;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public void setChar1(char char1) {
        this.char1 = char1;
    }

    public int getResult() {
        return result;
    }

}
