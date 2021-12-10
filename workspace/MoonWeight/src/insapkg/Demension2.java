package insapkg;

public class Demension2 {
	public static void main(String[] args) {
		/*int[][] arr = new int[3][3];*/
		
		/*for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = 3*i+j+1;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}*/
		
		/*int cnt = 1;
		for(int i=0; i<3; i++) {
			for(int j=0; j<=i; j++) {
				arr[i][j] = cnt++;
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}*/
		
//		1 	2 	4	 5	11
//		3	5	8	12	16
//		6	9	13	17	20
//		10	14	18	21	23
//		15	19	22	24	25
		
/*
 * 		00	01	02	03	04
 * 		10	11	12	13	14
 * 		20	21	22	23	24
 * 		30	31	32	33	34
 * 		40	41	42	43	44
 * 
 */		
		
		// rain
		
		/*int[][] rain = new int[5][5];
		int sum = 0 , cnt = 1, num = 1;
		boolean turning = true;
		
		for(int k=0; k<25; k++) {
			int temp = 0;
			boolean check = false;
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(i+j == sum) {
						rain[i][j] = num++;
						if(++temp == cnt) {
							if(turning) cnt++;
							else cnt--;
							
							if(cnt >= 5) turning = false;
							check = true;
							sum++;
							break;
						}
					}
				}
				if(check) break;
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(rain[i][j] + "\t");
			}
			System.out.println();
		}*/
		
		// snail
		
		/*int[][] snail = new int[5][5];
		int i=0, j=0;
		int mode = 0;
		
		for(int k=1; k<=25; k++) {
			snail[i][j] = k;
			switch(mode){
			case 0:
				j++;
				if(j >=5 || snail[i][j] !=0) {
					mode = 1;
					j--; i++;
				}
				break;
			case 1:
				i++;
				if(i >=5 || snail[i][j] !=0) {
					mode = 2;
					i--; j--;
				}
				break;
			case 2:
				j--;
				if(j < 0 || snail[i][j] !=0) {
					mode = 3;
					j++; i--;
				}
				break;
			case 3:
				i--;
				if(snail[i][j] != 0) {
					mode = 0; 
					i++; j++;
				}
				break;
			}
		}
		
		for(i=0; i<5; i++) {
			for(j=0; j<5; j++) {
				System.out.print(snail[i][j] + "\t");
			}
			System.out.println();
		}*/
		
		/*int[][] init = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
		
		for(int i=0; i<init.length; i++) {
			for(int j=0; j<init[i].length; j++) {
				System.out.print(init[i][j] + "\t");
			}
			System.out.println();
		}*/
		
		int[] arr = { 3 ,5 , 9, 65, 78, 14, 22, 30, 99, 64 };
		
		int sum = getSum(arr);
		System.out.println(sum);
		
	}

	private static int getSum(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) sum += arr[i];
		return sum;
	}
	
	
	
}
