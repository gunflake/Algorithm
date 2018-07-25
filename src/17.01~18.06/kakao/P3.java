package kakao;

import java.util.LinkedList;

public class P3 {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		LinkedList<String> cash = new LinkedList<>();

		for (int i = 0; i < cities.length; i++) {
			String tmp = cities[i].toLowerCase();
			answer += searchCash(cash, tmp, cacheSize);
		}

		return answer;
	}

	public int searchCash(LinkedList<String> cash, String target, int cacheSize) {
		
		if(cacheSize==0) {
			return 5;
		}
		
		if (cash.size() < cacheSize) {
			for (int i = 0; i < cash.size(); i++) {
				if (cash.get(i).equals(target)) {
					cash.remove(i);
					cash.add(target);
					return 1;
				}
			}
			cash.add(target);
			return 5;
		} else {
			for (int i = 0; i < cacheSize; i++) {
				if (cash.get(i).equals(target)) {
					cash.remove(i);
					cash.add(target);
					return 1;
				}
			}

			cash.remove(0);
			cash.add(target);
			return 5;
		}
	}

	public static void main(String[] args) {
		P3 p = new P3();
		String[] a = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(p.solution(0, a));

	}

}
