package calculator.calculator1;

import calculator.calculator2.Calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("첫번째 '0'포함 양의 정수를 입력하세요: ");
            int num1;
            try {
                num1 = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("정수만 입력해주세요.");
                continue;
            }

            System.out.print("두번째 '0'포함 양의 정수를 입력하세요: ");
            int num2;
            try {
                num2 = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("정수만 입력해주세요.");
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            String str1 = scanner.next();
            char char1 = str1.charAt(0);
            try {
                if(char1 != '+' && char1 != '-' && char1 != '*' && char1 != '/') {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("사칙연산 기호를 입력해주세요.");
                continue;
            }

            Calculator cal = new Calculator();
            cal.setNum1(num1);
            cal.setNum2(num2);
            cal.setChar1(char1);

            cal.calculator();
            int res = cal.getResult();

            if (num2 != 0 || char1 != '/') {
                System.out.println("res = " + res);
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String str2 = scanner.next();
            if (str2.equals("exit")) {
                break;
            }
        }

    }


}