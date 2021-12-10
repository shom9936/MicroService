package insapkg;

import java.util.Scanner;

public class MethodPractice2 {

	public static void main(String[] args) {
		
		// Ű�� �����Ը� �Է¹޾� bmi ����� ����ϴ� �ڹ� ���α׷��� �ۼ��Ͻÿ�
		// ��, �޼ҵ� 1�������� �ۼ�
		// ����
		// bmi	30�ʰ� ��, 25~30 ��ü��, 20~25 ����, 20�̸� ��ü��
		// bmi ��� ��� : bmi = (������) / (����Ű�� ����)
		
		Scanner scan = new Scanner(System.in);
		double weight;
		double height;
		
		System.out.print("Ű�� �Է��ϼ��� : ");
		height = scan.nextDouble();
		System.out.print("�����Ը� �Է��ϼ��� : ");
		weight = scan.nextDouble();
		double height_m = height/100.0;
		
		double bmi = calculateBMI(height_m, weight);
		System.out.printf("%.2f\n", bmi);
		System.out.println(String.format("%.2f", bmi));
		
		if(bmi > 30) System.out.println("���Դϴ�.");
		else if(bmi >25) System.out.println("��ü���Դϴ�.");
		else if(bmi > 20) System.out.println("�����Դϴ�.");
		else System.out.println("��ü���Դϴ�.");
	}

	private static double calculateBMI(double height_m, double weight) {
		
		return weight / Math.pow(height_m, 2.0);
	}

}