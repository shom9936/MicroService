package insapkg;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HelloInsa {

	public static void main(String[] args) {
		
		System.out.print("안녕 자바");
		System.out.println(); 
		// ctrl + shift + L : 단축키 알려주는 단축키

		
		System.out.printf("%s\n", "세젤예");
		System.out.printf("%s\n", "비담");
		System.out.printf("%s%n", "세젤예");
		
		if(125 % 3 == 0) {
			System.out.println("3의 배수");
		} else {
			System.out.println("3의배수가 아님");
		}
		
		int jum = 85;
		char hak;
		if(jum >= 90) hak = 'A';
		else if(jum >=80) hak = 'B';
		else if(jum>=70) hak = 'C';
		else if(jum>=60) hak = 'D';
		else hak = 'F';
		
		Scanner scan = new Scanner(System.in);
		String menu;
		do {
			System.out.print("1. 짜장   2. 짬뽕 :");
			menu = scan.next();
			
			if(menu.equals("1") || menu.equals("2")) {
				System.out.println("맛점하세요");
			} else {
				System.out.println("잘못입력하셨습니다.");
				menu = null;
			}
		}while(menu == null);
		scan.close();
		
	}

}
