package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cheese_o2638 {
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,-1,0,1};
	static int [][] board;
	
	public static void main(String[] args) throws IOException {

		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<m;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		//solve & output
		System.out.println(solve(board, n, m));
		
	}
	

	private static int solve(int[][] before, int n, int m) {
		int time = 0;
		
		
		while(true) {
			boolean flag = true;
			outsideCheck(before, 0, 0);
			int [][] after = new int[n][m];
			
			for(int a=0;a<n;a++) {
				for(int b=0;b<m;b++) {
					
					if(before[a][b] == 1) {
						after[a][b] = check(before, a, b);
						flag = false;
					}
					
				}
			}
			
			if(flag)
				break;
			
			time++;
			before = after;
		}
		
		
		return time;
	}

	private static void outsideCheck(int [][] before, int a, int b) {
		if(a < 0 || a >= before.length || b < 0 || b>= before[0].length)
			return;
		if(before[a][b]==0) {
			before[a][b]=2;
			outsideCheck(before, a+1, b);
			outsideCheck(before, a, b+1);
			outsideCheck(before, a-1, b);
			outsideCheck(before, a, b-1);
		}
		
	}
	
	private static int check(int[][] before, int a, int b) {
		int result = 0;
		for(int i=0;i<4;i++) {
			if(before[a+dy[i]][b+dx[i]]==2)
				result++;
		}
		
		if(result>= 2)
			return 0;
		else
			return 1;
	}
	
	

}
