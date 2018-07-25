package july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class o2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StairTotal stair = new StairTotal();
		
		int n = Integer.parseInt(br.readLine()); 
		int [] stairScore = new int [n+3];
		for (int i = 1; i <= n; i++) {
			stairScore[i]=Integer.parseInt(br.readLine());
		}
		
		//========================================
		
		System.out.println(stair.totalScore(stairScore, n));
		
		
		
		
	}

}

class StairTotal{
	public int totalScore(int[] stairScore, int length) {
		int [] totalScore = new int[length+3];
		
		totalScore[0]=0;
		totalScore[1]=stairScore[1];
		totalScore[2]=stairScore[1]+stairScore[2];
		
		for(int i=3;i<=length;i++) {
			totalScore[i]=Math.max(totalScore[i-2]+stairScore[i], totalScore[i-3]+stairScore[i-1]+stairScore[i]);
		}
		
		return totalScore[length];
	}
	
}
