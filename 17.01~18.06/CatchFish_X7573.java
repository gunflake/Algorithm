package algorithm.mid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CatchFish_X7573 {

	static boolean[][] board;

	// l=length, c= fishCount
	public static int solve(int n, int l, int c) {

		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				for (int x = 1; x < l; x++) {

					int tmp = check(i, j, x, l - x);
					if (max < tmp)
						max = tmp;
					
				}
			}
		}

		return max;
	}

	// first x,y & length X,Y
	public static int check(int fx, int fy, int lengthX, int lengthY) {

		int lx = fx + lengthX;
		int ly = fy + lengthY;

		if (lx >= board.length || ly >= board.length)
			return -1;

		int count = 0;

		for (int i = fx; i <= lx; i++) {
			for (int j = fy; j <= ly; j++) {
				if (board[i][j])
					count++;

			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// s = board_size, l = length, n = fishCount
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken()) / 2;
		int c = Integer.parseInt(st.nextToken());

		board = new boolean[n][n];

		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
		}

		// solve
		System.out.println(solve(n, l, c));

	}

}
