package insapkg;

public class Score {

	public static void main(String[] args) {
		int score[] = {100, 75, 89 };
		int sum = 0; 
		
		for(int i=0; i< score.length; i++) sum += score[i];
		System.out.println("���� : " + sum);
		System.out.println("��� : " + (double)sum/score.length);

	}

}
