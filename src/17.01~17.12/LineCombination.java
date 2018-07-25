package september;

import java.util.Arrays;
import java.util.LinkedList;

class LineCombination {
	public int[] setAlign(int n, long k) {
		int[] answer = new int[n];
		long[] d = new long[n];

		k -= 1;

		LinkedList<Integer> link = new LinkedList<>();

		d[0] = 1;
		d[1] = 1;

		for (int i = 2; i < n; i++)
			d[i] = d[i - 1] * i;

		for (int i = 0; i < n; i++)
			link.add(i + 1);

		for (int i = 0; i < answer.length; i++) {
			int tmp = (int) (k / d[--n]);
			answer[i] = link.remove(tmp);
			k =  (k % d[n]);
		}

		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		LineCombination lc = new LineCombination();
		System.out.println(Arrays.toString(lc.setAlign(15, 993109582544L)));
	}
}
