/*
 * http://codeforces.com/contest/996/problem/B
 */

package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WorldCup {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] e = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < n; i++) {
			e[i] = Integer.parseInt(st.nextToken());
		}

		// solve
		System.out.println(solve(n, e));

	}

	private static int solve(int n, int[] e) {
		int minQuotient = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int tmp = e[i] / n;
			if (minQuotient > tmp)
				minQuotient = tmp;
			if (minQuotient == 0)
				break;
		}

		// 압축
		int minus = minQuotient * n;
		for (int i = 0; i < n; i++) {
			e[i] -= minus;
		}

		// search
		int cnt = 0;
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < n; i++, cnt++) {
				if (e[i] - cnt <= 0) {
					return i + 1;
				}
			}
		}

		return -1;
	}
}
