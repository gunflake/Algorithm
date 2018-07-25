import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n];
		int[] operation = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < 4; i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}

		// solve
		dfs(numbers[0], operation, numbers, 1, n); // calculation, 연산자, 수, 현재위치 , 총 수
		System.out.println(max);
		System.out.println(min);

	}

	private static void dfs(int sum, int[] operation, int[] numbers, int now, int n) {
		if (now == n) {
			if (max < sum)
				max = sum;
			if (min > sum)
				min = sum;
		}

		for (int i = 0; i < 4; i++) {
			if (operation[i] > 0) {
				operation[i]--;
				int tmp = calculate(sum, numbers[now], i);
				dfs(tmp, operation, numbers, now + 1, n);
				operation[i]++;
			}
		}

	}

	private static int calculate(int a, int b, int operation) {
		if (operation == 0) {
			return a + b;
		} else if (operation == 1) {
			return a - b;
		} else if (operation == 2) {
			return a * b;
		} else if (operation == 3) {
			return a / b;
		} else
			return -1;
	}

}
