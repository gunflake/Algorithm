package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeTriangle_X2622 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				int k = n - i - j;
				if(j>k)
					break;
				if (i + j > k)
					result++;
			}

		}

		System.out.println(result);

	}

}
