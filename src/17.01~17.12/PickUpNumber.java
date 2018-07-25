package july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PickUpNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PickUp pickUp = new PickUp();

		int testCase = Integer.parseInt(br.readLine());
		int[] parseInt = null;
		for (int i = 0; i < testCase; i++) {
			int count = 0;
			int n = Integer.parseInt(br.readLine());
			parseInt = new int[n];
			String parse = br.readLine();
			StringTokenizer st = new StringTokenizer(parse, " ");
			while (st.hasMoreTokens())
				parseInt[count++] = Integer.parseInt(st.nextToken());

			System.out.println("Case #" + (i + 1));
			System.out.println(pickUp.xorOperation(parseInt, n));

		}

	}// main
}

class PickUp {

	public int xorOperation(int[] parseInt, int length) {
		int[][] checkInt = new int[length][2];
		int result = 0;
		boolean firstValue = false;
		
		for (int i = 0; i < parseInt.length; i++) {
			for (int j = 0; j < length; j++) {
				if (checkInt[j][0] == parseInt[i]) {
					checkInt[j][1]++;
					break;
				}

				if (checkInt[j][0] == 0) {
					checkInt[j][0] = parseInt[i];
					checkInt[j][1]++;
					break;
				}

			}
		}

		for (int i = 0; i < checkInt.length; i++) {

			if (checkInt[i][1] % 2 == 1) {
				if (!firstValue) {
					result = checkInt[i][0];
					firstValue = true;
					continue;
				}

				result = result ^ checkInt[i][0];

			}
		}
		return result;
	}
}
