package sundayStudy;

import java.util.LinkedList;

public class P1 {
	public static void main(String[] args) {

		P1 p = new P1();
		// System.out.println(p.shiftingLetters("abc", new int[] {3,5,9}));
		// System.out.println(p.shiftingLetters("gdhbjaph", new int[] { 74, 34, 65, 30,
		// 43, 91, 14, 10 }));
		// System.out.println(p.maxDistToClosest(new int[] { 0, 1 }));
		System.out.println(
				p.loudAndRich(new int[][] { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 7 }, { 4, 3 }, { 5, 3 }, { 6, 3 } },
						new int[] { 3, 2, 5, 4, 6, 1, 7, 0 }));

	}

	public int[] loudAndRich(int[][] richer, int[] quiet) {
		int num = quiet.length;

		int[] result = new int[num];

		LinkedList<Integer>[] list = new LinkedList[num];
		for (int i = 0; i < list.length; i++)
			list[i] = new LinkedList<>();

		for (int i = 0; i < richer.length; i++) {
			list[richer[i][1]].add(richer[i][0]);
		}

		for (int i = 0; i < num; i++) {
			int v = Integer.MAX_VALUE;
			int p = -1;

			LinkedList<Integer> tmp = new LinkedList<>();

			add(list, tmp, i);

			for (int k = 0; k < tmp.size(); k++) {
				if (v >= quiet[tmp.get(k)]) {
					v = quiet[tmp.get(k)];
					p = tmp.get(k);
				}
			}
			if (p == -1) {
				result[i] = i;
			} else {
				if (v <= quiet[i])
					result[i] = p; // v==1
				else
					result[i] = i;
			}
		}

		return result;
	}

	private void add(LinkedList<Integer>[] list, LinkedList<Integer> tmp, int i) { // i=position

		for (int k = 0; k < list[i].size(); k++) {

			int t = list[i].get(k);

			if (tmp.contains(t)) {
				continue;
			}

			tmp.add(t);
			add(list, tmp, t);
		}
	}

	public int maxDistToClosest(int[] seats) {
		int[] dis = new int[seats.length];

		int first = -1, last = -1;

		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				first = i;
				break;
			}
		}

		for (int i = seats.length - 1; i >= 0; i--) {
			if (seats[i] == 1) {
				last = i;
				break;
			}
		}

		int sum = -1;
		for (int i = first; i < seats.length; i++) {
			if (seats[i] == 1) {
				sum = 1;
			} else {
				dis[i] = sum++;
			}
		}

		sum = -1;
		for (int i = last; i >= 0; i--) {
			if (seats[i] == 1) {
				sum = 1;
			} else {
				if (dis[i] > sum || dis[i] == 0) {
					dis[i] = sum++;
				}

			}
		}

		int max = -1;
		for (int i = 0; i < dis.length; i++) {
			if (max < dis[i])
				max = dis[i];
		}

		return max;
	}

	public String shiftingLetters(String S, int[] shifts) {
		String result = "";

		for (int i = 0; i < shifts.length; i++) {
			if (shifts[i] >= 26)
				shifts[i] %= 26;
		}

		for (int i = 1; i < shifts.length; i++) {

			for (int j = 0; j < i; j++) {
				shifts[j] += shifts[i];

			}
		}

		for (int i = 0; i < S.length(); i++) {

			int t = S.charAt(i) - 'a';

			t += shifts[i];
			if (t >= 26) {
				t %= 26;
			}
			t = t + 'a';
			result = result + (char) t;

		}

		return result;
	}

}