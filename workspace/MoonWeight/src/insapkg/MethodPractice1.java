
package insapkg;

import java.util.Scanner;

public class MethodPractice1 {

	public static void main(String[] args) {

		// Ű�� �����Ը� �Է¹޾� bmi ����� ����ϴ� �ڹ� ���α׷��� �ۼ��Ͻÿ�
		// ��, �޼ҵ� 1�������� �ۼ�
		// ����
		// bmi	30�ʰ� ��, 25~30 ��ü��, 20~25 ����, 20�̸� ��ü��
		// bmi ��� ��� : bmi = (������) / (����Ű�� ����)
		calculateBMI();
		
	}

	private static void calculateBMI() {
		Scanner scan = new Scanner(System.in);
		double weight;
		double height;
		
		System.out.print("Ű�� �Է��ϼ��� : ");
		height = scan.nextDouble();
		System.out.print("�����Ը� �Է��ϼ��� : ");
		weight = scan.nextDouble();
		double bmi = weight / Math.pow(height/100, 2.0);
		
		if(bmi > 30) System.out.println("���Դϴ�.");
		else if(bmi >25) System.out.println("��ü���Դϴ�.");
		else if(bmi > 20) System.out.println("�����Դϴ�.");
		else System.out.println("��ü���Դϴ�.");
	}

}
