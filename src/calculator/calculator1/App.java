package calculator.calculator1;

import calculator.calculator2.Calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("첫번째 '0'포함 양의 정수를 입력하세요: ");
            int num1 = scanner.nextInt();

            System.out.print("두번째 '0'포함 양의 정수를 입력하세요: ");
            int num2 = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            String str1 = scanner.next();
            char char1 = str1.charAt(0);

            Calculator cal = new Calculator(num1, num2, char1);

            int res = 0;
            if (char1 == '+') {
                res = cal.sum();
            } else if (char1 == '-') {
                res = cal.sub();
            } else if (char1 == '*') {
                res = cal.mul();
            } else if (char1 == '/') {
                try {
                    if (num2 != 0) {
                        res = cal.div();
                    } else {
                        throw new ArithmeticException();
                    }
                } catch (ArithmeticException e) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    continue;
                }
            }

            System.out.println("res = " + res);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String str2 = scanner.next();
            if (str2.equals("exit")) {
                break;
            }
        }

    }


}