import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int dx = 0;
	static int dy = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//testcase
		for (int i = 1; i <= 10; i++) {

			// input
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			for (int a = 0; a < n; a++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int b = 0; b < n; b++) {
					board[a][b] = Integer.parseInt(st.nextToken());
				}
			}

			// solve
			for (int a = 0; a < n; a++) //n번 만큼 보드판 이동 N극은 밑으로 S극은 위로 교착상태면 멈춤
				move(board, n);

			
			// 교착세기 

			int count = 2;
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					if (board[a][b] == 1 ) { //좌석이 N극이면 dfs탐색
						count++;
						dfs(board, a, b,1, count);  // 자석이 없을때까지 탐색
					}
				}
			}
			
			//output
			count -= 2;
			bw.write("#" + i + " " + count);
			bw.newLine();
		}

		
		bw.flush();

	}

	private static void dfs(int[][] board, int y, int x,int flag, int count) { //flag 1212 구별하기위해
		if (board[y][x] < 1 || board[y][x] > 2) {
			return;
		}
		
		if(board[y][x]<flag) {
			return;
		}

		flag = board[y][x];
		
		board[y][x] = count;

		if(y+dy<board.length)
			dfs(board, y + dy, x + dx, flag ,count);

	}


	private static void move(int[][] board, int size) {
		for (int i = 0; i < size; i++) { //s극은 위로 올라가므로 순차적으로 탐색 
			for (int j = 0; j < size; j++) {
				if (board[i][j] == 2) { // S극일때

					if (i - 1 < 0) {
						board[i][j] = 0;
						continue;
					}

					if (board[i - 1][j] == 1 || board[i - 1][j] == 2) {
						continue;
					}

					board[i][j] = 0;
					board[i - 1][j] = 2;
				}
			}
		}

		for (int i = size - 1; i >= 0; i--) { //n극은 밑으로 내려가므로 역으로 탐색
			for (int j = size - 1; j >= 0; j--) {

				if (board[i][j] == 1) { // N극일때

					if (i + 1 >= size) {
						board[i][j] = 0;
						continue;
					}

					if (board[i + 1][j] == 2 || board[i + 1][j] == 1) {
						continue;
					}

					board[i][j] = 0;
					board[i + 1][j] = 1;
				}
			}
		}
	}
}
