package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int max = 0;

	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int[][] board = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];

		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// solve

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, j, i, -1, -1, 0, 0);

			}
		}

		
		exceptionBlock(board);
		
		System.out.println(max);

	}

	private static void exceptionBlock(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				
				if(widthSafe(board, j, i)) {
					int up=0;
					int down=0;
					int sum=board[i][j]+board[i][j+1]+board[i][j+2];
					
					if(i-1>=0) {
						up = board[i-1][j+1];
					}
					
					if(i+1<board.length) {
						down = board[i+1][j+1];
					}
					
					if(up>down)
						sum+=up;
					else
						sum+=down;
					
					if(max<sum)
						max=sum;
				}
				
				if(heightSafe(board, j, i)) {
					
					
					
					int left=0;
					int right=0;
					int sum=board[i][j]+board[i+1][j]+board[i+2][j];
					
					if(j-1>=0) {
						left = board[i+1][j-1];
					}
					
					if(j+1<board[0].length) {
						right = board[i+1][j+1];
					}
					
					if(left>right)
						sum+=left;
					else
						sum+=right;
					
					if(max<sum)
						max=sum;
					
					
				}
				
				
				
			}
		}
	}
	
	private static boolean widthSafe(int[][] board, int x,int y) {
		if(x+2<board[0].length)
			return true;
		else
			return false;
	}
	
	private static boolean heightSafe(int[][] board, int x,int y) {
		if(y+2<board.length)
			return true;
		else
			return false;
	}
	
		

	private static void dfs(int[][] board, int x, int y, int ox, int oy, int value, int count) {
		if (count == 4) {
			if (max < value)
				max = value;
			return;
		}

		for (int i = 0; i < 4; i++) {

			int cx = x + dx[i];
			int cy = y + dy[i];

			if (safe(board, cx, cy)) {
				if (cx == ox && cy == oy)
					continue;
				dfs(board, cx, cy, x, y, value + board[y][x], count + 1);
			}

		}

	}

	private static boolean safe(int[][] board, int x, int y) {
		if (x >= 0 && x < board[0].length && y >= 0 && y < board.length)
			return true;
		else
			return false;
	}

}
