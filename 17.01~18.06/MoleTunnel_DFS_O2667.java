package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 단지 번호 붙이기 (그래프 문제) - DFS를 이용해서 풀음
 */

public class MoleTunnel_DFS_O2667 {

	static int[][] board;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static boolean outOfBound(int x, int y) {
		if (x >= 0 && y >= 0 && x < board.length && y < board.length)
			return true;
		else
			return false;
	}

	public static void recur(int x, int y, int cnt) {

		for (int i = 0; i < 4; i++) {
			if (outOfBound(x + dx[i], y + dy[i]) && board[x + dx[i]][y + dy[i]] == 1) {
				board[x + dx[i]][y + dy[i]] = cnt;
				recur(x + dx[i], y + dy[i], cnt);
			}
		}

	}

	public static int[] solve() {

		int cnt = 1;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) {
					board[i][j]=++cnt;
					recur(i, j, cnt);
				}

			}
		}

		int[] result = new int[cnt + 1];
		int[] returnR = new int[cnt-1];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				result[board[i][j]]++;
			}
		}
		
		for(int i=0;i<returnR.length;i++)
			returnR[i]=result[i+2];
		
		return returnR;
	}

	public static void main(String[] args) throws IOException {

		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();

			for (int j = 0; j < tmp.length(); j++)
				board[i][j] = tmp.charAt(j) - '0';
		}

		int[] result = solve();
		Arrays.sort(result);
		System.out.println(result.length);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);

	}
}
