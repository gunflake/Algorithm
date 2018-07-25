package algorithm.mid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SuprisePrime_o2023_BruteForce {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int maxNum = maxNum(n);
		solve(n, maxNum);
	}

	public static void solve(int n, int maxNum) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] check = new boolean[maxNum];

		check[0] = true;
		check[1] = true;

		for (int i = 2; i < maxNum; i++) {
			if (!check[i]) {
				for (int j = i * 2; j < maxNum; j += i) {
					check[j] = true;
				}
			}
		}

		for (int i = maxNum / 10; i < maxNum; i++) {
			if (!check[i]) {
				int tmp = i / 10;
				while (tmp > 0) {
					if (!check[tmp]) {
						tmp /= 10;
					} else
						break;
				}
				
				if(tmp==0) {
					bw.write(i+"\n");
				}

			}

		}
		
		bw.flush();

	}

	public static int maxNum(int n) {
		int tmp = 1;
		for (int i = 0; i < n; i++) {
			tmp *= 10;
		}
		return tmp;
	}

}
