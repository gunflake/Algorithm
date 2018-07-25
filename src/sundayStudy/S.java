package sundayStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;



public class S {


	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] knight = new int[2][n]; /// row 0 = power, row 1 = coin

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				knight[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// solve
		ArrayList<Knight> list = new ArrayList<>();
		sortByPower(list, knight);
		Collections.sort(list, new Comparator<Knight>() {

			@Override
			public int compare(Knight o1, Knight o2) {
				if (o1.power > o2.power)
					return 1;
				else if (o1.power < o2.power)
					return -1;
				else
					return 0;
			}
		});

		int[] coinPocket;
		if (k != 0) {
			coinPocket = new int[k];
		} else {
			for (int i = 0; i < n; i++)
				bw.write(knight[1][i] + " ");
			bw.flush();
			return;
		}

		HashMap<Integer, Long> map = new HashMap<>();
		map.put(list.get(0).power, 0L);

		for (int i = 1; i < n; i++) {
			Arrays.sort(coinPocket);

			if (coinPocket[0] == 0) {
				coinPocket[0] = list.get(i - 1).coin;
			} else {
				coinPocket[0] = returnMax(coinPocket[0], list.get(i - 1).coin);
			}
			map.put(list.get(i).power, coinSum(coinPocket));
		}

		for (int i = 0; i < n; i++) {
			long t = map.get(knight[0][i]) + knight[1][i];
			bw.write(t + " ");
		}
		bw.flush();
		bw.close();

	}

	public static long coinSum(int[] coinPocket) {
		long tmp = 0;
		for (int i = 0; i < coinPocket.length; i++)
			tmp += coinPocket[i];
		return tmp;
	}

	public static int returnMax(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public static void sortByPower(ArrayList<Knight> list, int[][] knight) {
		for (int i = 0; i < knight[0].length; i++) {
			list.add(new Knight(knight[0][i], knight[1][i]));
		}
	}

}

class Knight {
	public int power;
	public int coin;
	
	public Knight(int power, int coin) {
		this.power = power;
		this.coin = coin;
	}
	
}
