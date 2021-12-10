package insapkg;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
        	int[] answer;
            int length = commands[i][1] - commands[i][0] + 1;
            answer = new int[length];
            for(int j=0; j<length; j++) {
            	answer[j] = array[j+commands[i][0]-1];
            }
            Arrays.sort(answer);
            result[i] = answer[commands[i][2] -1];
        }
        return result;
    }
    
    public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		Solution s = new Solution();
		
		int[] result = s.solution(array, commands);
		
		for(int i=0; i<result.length; i++) System.out.println(result[i]);
	}
}