package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1 {

	public LinkedList<Integer> solution(LinkedList<Integer> list) {

		LinkedList<Integer> result = new LinkedList<>();
		LinkedList<Integer> queue = new LinkedList<>();

		for (int i = 0; i < list.size(); i++) {
			int tmp = list.get(i);
			boolean flag = false;

			if (queue.size() < 3) {

				for (int j = 0; j < queue.size(); j++) {
					if (tmp == queue.get(j)) {
						queue.remove(j);
						queue.add(tmp);
						flag = true;
						break;
					}
				}
				if (!flag)
					queue.add(tmp);
			} else { // size==3일때
				for (int j = 0; j < queue.size(); j++) {
					if (tmp == queue.get(j)) {
						queue.remove(j);
						queue.add(tmp);
						flag = true;
						break;
					}
				}
				if (!flag) {
					result.add(queue.remove(0));
					queue.add(tmp);
				}
			}

		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> result = new LinkedList<>();

		P1 p1 = new P1();

		while (st.hasMoreTokens())
			list.add(Integer.parseInt(st.nextToken()));

		result = p1.solution(list);

		if (result.size() == 0)
			System.out.println(0);
		else
			for (int i = 0; i < result.size(); i++)
				System.out.println(result.get(i));

	}

}
