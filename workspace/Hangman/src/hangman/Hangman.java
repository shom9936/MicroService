package hangman;

import java.util.Scanner;

public class Hangman {
	private String answer;
	
	public Hangman(String answer) {
		this.answer = answer;
	}
	
	public void playHangman() {
		
		String result= "";
		boolean check[] = new boolean[answer.length()];
		Scanner scan = new Scanner(System.in);
		
		int cnt = 0;
		int checkCnt=0;
		
		for(int i=0; i<13; i++) {
			result=makeResult(check , answer);
			
			System.out.println(result);
			System.out.print("���ĺ��� �Է��ϼ���(���� Ƚ�� : " + (13-i) + ") :");
			String in = scan.next();
			
			if(in.length() > 1) {
				System.out.println("���� �ϳ��� �Է��ϼ���");
				i--;
				continue;
			}
			
			for(int j=0; j<answer.length(); j++) {
				if(answer.charAt(j) == in.charAt(0)) {
					check[j] = true;
					cnt++;
				}
			}
			
			if(cnt != checkCnt) {
				i--;
				checkCnt = cnt;
			}
			
			if(cnt == answer.length()) {
				System.out.println(answer);
				System.out.println("�����մϴ�. ������ ���߼̽��ϴ�!");
				return;
			}
			
		}
		
		System.out.println("���� : " + answer);
	}
	
	private static String makeResult(boolean[] check, String answer) {
		String temp ="";
		for(int i=0; i<answer.length(); i++) {
			if(check[i]) {
				temp += answer.charAt(i);
			} else {
				temp += "_";
			}
		}
		return temp;
		
	}
	
	
}
