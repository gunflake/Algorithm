import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			int k = Integer.parseInt(br.readLine());
			int[][] direction = new int[k][2];
			
			LinkedList<Integer>[] mag = new LinkedList[4];

			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				mag[i] = new LinkedList<>();
				for (int j = 0; j < 8; j++) {
					mag[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				direction[i][0] = Integer.parseInt(st.nextToken());
				direction[i][1] = Integer.parseInt(st.nextToken());
			}
			
			//solve & output
			
			for (int i = 0; i < k; i++) {
				change(mag, direction[i][0] - 1, direction[i][1]);
			}
			
			int result = mag[0].get(0) + mag[1].get(0) * 2 + mag[2].get(0) * 4 + mag[3].get(0) * 8;
			
			bw.write("#"+test+" "+result);
			bw.newLine();

		}

		bw.flush();



	}

	private static void change(LinkedList<Integer>[] t, int selected, int direction) {

		boolean[] check = new boolean[3];

		check[0] = checkT(t[0], t[1]);
		check[1] = checkT(t[1], t[2]);
		check[2] = checkT(t[2], t[3]);

		move(t[selected], direction);

		if (selected == 0) {
			if (check[0])
				move(t[1], direction * -1);
			if (check[0] && check[1])
				move(t[2], direction);
			if (check[0] && check[1] && check[2])
				move(t[3], direction * -1);
		} else if (selected == 1) {

			if (check[0])
				move(t[0], direction * -1);
			if (check[1])
				move(t[2], direction * -1);
			if (check[1] && check[2])
				move(t[3], direction);
		} else if (selected == 2) {

			if (check[1])
				move(t[1], direction * -1);
			if (check[1] && check[0])
				move(t[0], direction);
			if (check[2])
				move(t[3], direction * -1);
		} else if (selected == 3) {
			if (check[2])
				move(t[2], direction * -1);
			if (check[2] && check[1])
				move(t[1], direction);
			if (check[2] && check[1] && check[0])
				move(t[0], direction * -1);
		}

	}

	private static void move(LinkedList<Integer> t, int direction) {
		if (direction == 1) {
			int tmp = t.removeLast();
			t.addFirst(tmp);
		} else {
			int tmp = t.removeFirst();
			t.add(tmp);
		}
	}

	private static boolean checkT(LinkedList<Integer> a, LinkedList<Integer> b) {
		if (a.get(2) != b.get(6))
			return true;
		else
			return false;
	}

}
