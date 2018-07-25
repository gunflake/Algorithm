package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen_DFS_O9663 {

	static int count = 0;
	static boolean[] col;
	static boolean[] leftCross;
	static boolean[] rightCross;

	public static void solve(int x, int n, int rest) {
		if (rest == 0) {
			count++;
			return;
		} else {
			for (int i = 0; i < n; i++) {
				if (col[i] || leftCross[x + i] || rightCross[x - i + n - 1])
					continue;
				else {
					col[i] = leftCross[x + i] = rightCross[x - i + n - 1] = true;
					solve(x + 1, n, rest - 1);
					col[i] = leftCross[x + i] = rightCross[x - i + n - 1] = false;
				}
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		col = new boolean[n];
		leftCross = new boolean[2 * n - 1];
		rightCross = new boolean[2 * n - 1];
		
		solve(0,n,n);
		System.out.println(count);

	}

}
