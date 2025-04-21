package calculator.calculator3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Double> resultArr = new ArrayList<>();

        while (true) {
            System.out.print("첫번째 '0'포함 실수를 입력하세요: ");
            double num1;
            try {
                num1 = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("정수만 입력해주세요.");
                scanner.nextLine(); // 문자 입력 시 무한루프 방지를 위해 버퍼 비우는 코드
                continue;
            }

            System.out.print("두번째 '0'포함 실수를 입력하세요: ");
            double num2;
            try {
                num2 = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("실수만 입력해주세요.");
                scanner.nextLine(); // 문자 입력 시 무한루프 방지를 위해 버퍼 비우는 코드
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
                scanner.nextLine(); // 문자 입력 시 무한루프 방지를 위해 버퍼 비우는 코드
                continue;
            }

            ArithmeticCalculator<Number, Number, Character> cal = new ArithmeticCalculator<>();
            cal.setNum1(num1);
            cal.setNum2(num2);
            cal.setChar1(char1);

            cal.calculate();
            Double res = cal.getResult();

            if (num2 != 0 || char1 != '/') {
                System.out.println("계산 결과값 : " + res);
                resultArr.add(res);
                System.out.println("누적된 계산 결과값 : " + resultArr);
                System.out.println("가장 오래된 결과값을 삭제하시겠습니까? (Y 입력시 삭제)");
                char char2 = scanner.next().charAt(0);
                if(char2 == 'Y') {
                    // 가장 오래된 결과값 삭제하는 메서드
                    cal.resultDelete(resultArr);
                }
            }

            // 입력한 두 수 사잇값 출력하는 메서드
            cal.betweenNums(resultArr);

            System.out.print("입력한 수보다 큰 결과값을 조회합니다. 실수를 입력해주세요. ");
            double num3;
            try {
                num3 = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("실수만 입력해주세요.");
                scanner.nextLine(); // 문자 입력 시 무한루프 방지를 위해 버퍼 비우는 코드
                continue;
            }
            // 세번째 수 입력 받아 보다 큰 결과값만 출력하는 메서드
            cal.findNums(resultArr, num3);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String str2 = scanner.next();
            if (str2.equals("exit")) {
                break;
            }
        }

    }


}