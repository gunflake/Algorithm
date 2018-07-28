import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int flag = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] board = new int[d][w];
			for (int a = 0; a < d; a++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int b = 0; b < w; b++) {
					board[a][b] = Integer.parseInt(st.nextToken());
				}
			}

			// solve
			solve(board, d, w, k);

			// output
			bw.write("#"+i+" "+flag);
			bw.newLine();
			flag = -1;

		}
		
		bw.flush();
	}

	private static void solve(int[][] board, int d, int w, int k) {

		int count = 0;
		while(flag==-1) {
			dfs(board, 0, 0, count, k);
			count++;
			
		}

	}

	private static void dfs(int[][] board, int p, int now, int k, int target) {//보드, 현재위치, 헌재 투입횟수, 투입횟수.  
		if (now == k) {

			for(int x=0;x<board[0].length;x++) {
				if(checkRow(board, target, x)) {
					continue;
				}else {
					return;
				}
				
			}
			
			flag = k; //투여횟수
			
			return;

		}

		// A = 0 , B = 1 선택

		for (int i = p; i < board.length; i++) {
			for (int s = 0; s < 2; s++) {
				int[] tmp = board[i].clone();

				for (int x = 0; x < board[i].length; x++) { // board 1줄 A,B로 바꿈
					board[i][x] = s;
				}

				dfs(board, i + 1, now + 1, k, target);

				board[i] = tmp;

			}

		}

	}

	private static boolean checkRow(int[][] board, int k, int p) {

		for (int c = 0; c < 2; c++) {
			int count = 0;
			for (int i = 0; i < board.length; i++) {
				if(board[i][p]==c) {
					count++;
					if(count==k) {
						return true;
					}
				}else {
					count=0;
				}

			}
		}

		return false;
	}

}
