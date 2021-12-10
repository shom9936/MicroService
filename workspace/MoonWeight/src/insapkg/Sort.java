package insapkg;

public class Sort {

	public static void main(String[] args) {
		int[] k = {10, 90, 100, 60, 70, 23 };
		
		for(int i=0; i<k.length; i++) {
			for(int j=0; j<=i; j++) {
				if(k[i] > k[j]) {
					int temp = k[i];
					k[i] = k[j];
					k[j] = temp;
				}
			}
		}
		
		for(int i=0; i<k.length; i++) System.out.println(k[i]);

	}

}
