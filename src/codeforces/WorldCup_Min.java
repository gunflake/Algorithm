/*
 * http://codeforces.com/contest/996/problem/B
 */

package codeforces;

import java.io.*;
import java.util.StringTokenizer;

public class WorldCup_Min {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



		int n = Integer.parseInt(br.readLine());
		int[] e = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());


		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			e[i] = Integer.parseInt(st.nextToken());
			if(min>e[i])
				min=e[i];
		}

		// solve
		System.out.println(solve(n, e, min));
	}

	private static int solve(int n, int[] e, int min) {

		for (int i = 0; i < n; i++) {
			e[i]-=min;
		}

		int start = min%n;

		// search
		int cnt = 0;
		for (int k = 0; k < 2; k++) {
			for (int i = start; i < n; i++, cnt++) {
				if (e[i] - cnt <= 0) {
					return i + 1;
				}
			}
			start = 0;
		}

		return -1;
	}
}
