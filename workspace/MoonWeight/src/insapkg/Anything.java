package insapkg;

public class Anything {

	public static void main(String[] args) {
		
		String aa = "ondal";
		String bb = "ondal";
		
		if(aa == bb) System.out.println("같네");
		else System.out.println("다르네");
		
		int cnt=0;
		while(true) {
			System.out.println("*");
			if(++cnt==10) break;
		}
		
		for(int j=0, i=1; i<=20; j++, i++) {
			System.out.println("왕복달리기");
		}
		
		System.out.println("학년     -    반");
		for(int i=1; i<=3; i++) {
			for(int j =1; j<=2; j++) {
				System.out.println(i + "    -    "+j);
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5-i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for(int i=0; i<5; i++) {
			for(int j=0; j<5 ; j++) {
				if((i+j)>=4) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0; i<7; i++) {
			if(i<4) {
				for(int j=0; j<7; j++) {
					if(j>=i && j<7-i) System.out.print("*");
					else System.out.print(" ");
				}
				System.out.println();
			} else {
				for(int j=0; j<7; j++) {
					if(j >= 6-i && j < i+1) System.out.print("*");
					else System.out.print(" ");
				}
				System.out.println();
			}
		}
	}

}
