package calculator.calculator2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> resultArr = new ArrayList<>();

        while (true) {
            System.out.print("첫번째 '0'포함 양의 정수를 입력하세요: ");
            int num1;
            try {
                num1 = scanner.nextInt();
                if(num1 < 0) {
                    System.out.println("음수는 입력할 수 없습니다.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("정수만 입력해주세요.");
                scanner.nextLine(); // 문자 입력 시 무한루프 방지를 위해 버퍼 비우는 코드
                continue;
            }

            System.out.print("두번째 '0'포함 양의 정수를 입력하세요: ");
            int num2;
            try {
                num2 = scanner.nextInt();
                if(num1 < 0) {
                    System.out.println("음수는 입력할 수 없습니다.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("정수만 입력해주세요.");
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

            Calculator cal = new Calculator();
            cal.setNum1(num1);
            cal.setNum2(num2);
            cal.setChar1(char1);

            cal.calculator();
            int res = cal.getResult();

            if (num2 != 0 || char1 != '/') {
                System.out.println("계산 결과값 : " + res);
                resultArr.add(res);
                System.out.println("누적된 계산 결과값 : " + resultArr);
                System.out.println("가장 오래된 결과값을 삭제하시겠습니까? (Y 입력시 삭제)");
                char char2 = scanner.next().charAt(0);
                if(char2 == 'Y') {
                    cal.resultDelete(resultArr);
                    System.out.println("누적된 계산 결과값 : " + resultArr);
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String str2 = scanner.next();
            if (str2.equals("exit")) {
                break;
            }
        }

    }


}