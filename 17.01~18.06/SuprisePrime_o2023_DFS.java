package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuprisePrime_o2023_DFS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		check("", n);

	}

	private static void check(String s, int n) {
		if (s.length() == n)
			System.out.println(Integer.parseInt(s));
		else {

			for (int i = 0; i < 10; i++) {
				String tmp = s + i;

				if (dfs(Integer.parseInt(tmp))) {
					check(tmp, n);
				}
			}
		}

	}

	private static boolean dfs(int n) {
		if (n == 0)
			return false;
		else if (n == 1)
			return false;
		else if (n == 2)
			return true;
		else {
			for (int i = 2; i*i <= n; i++) {
				if (n % i == 0)
					return false;
			}
			return true;
		}

	}

}
