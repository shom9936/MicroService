package insapkg;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HelloInsa {

	public static void main(String[] args) {
		
		System.out.print("�ȳ� �ڹ�");
		System.out.println(); 
		// ctrl + shift + L : ����Ű �˷��ִ� ����Ű

		
		System.out.printf("%s\n", "������");
		System.out.printf("%s\n", "���");
		System.out.printf("%s%n", "������");
		
		if(125 % 3 == 0) {
			System.out.println("3�� ���");
		} else {
			System.out.println("3�ǹ���� �ƴ�");
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
			System.out.print("1. ¥��   2. «�� :");
			menu = scan.next();
			
			if(menu.equals("1") || menu.equals("2")) {
				System.out.println("�����ϼ���");
			} else {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				menu = null;
			}
		}while(menu == null);
		scan.close();
		
	}

}
