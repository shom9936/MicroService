
package insapkg;

import java.util.Scanner;

public class MethodPractice1 {

	public static void main(String[] args) {

		// 키와 몸무게를 입력받아 bmi 결과를 출력하는 자바 프로그램을 작성하시오
		// 단, 메소드 1형식으로 작성
		// 조건
		// bmi	30초과 비만, 25~30 과체중, 20~25 보통, 20미만 저체중
		// bmi 계산 방법 : bmi = (몸무게) / (미터키의 제곱)
		calculateBMI();
		
	}

	private static void calculateBMI() {
		Scanner scan = new Scanner(System.in);
		double weight;
		double height;
		
		System.out.print("키를 입력하세요 : ");
		height = scan.nextDouble();
		System.out.print("몸무게를 입력하세요 : ");
		weight = scan.nextDouble();
		double bmi = weight / Math.pow(height/100, 2.0);
		
		if(bmi > 30) System.out.println("비만입니다.");
		else if(bmi >25) System.out.println("과체중입니다.");
		else if(bmi > 20) System.out.println("보통입니다.");
		else System.out.println("저체중입니다.");
	}

}
