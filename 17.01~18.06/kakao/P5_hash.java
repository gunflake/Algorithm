package kakao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class P5_hash {

	public int solution(String str1, String str2) {

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		HashMap<String, Integer> h1 = new HashMap<>();
		HashMap<String, Integer> h2 = new HashMap<>();

		h1 = usado(str1);
		h2 = usado(str2);

		if(h1.size()==0 && h2.size()==0)
			return 65536;
		

		return value(h1, h2);
		
	}

	public int value(HashMap<String, Integer> h1, HashMap<String, Integer> h2) {

		int inter = 0;
		int union = 0;

		Iterator iterator1 = h1.entrySet().iterator();

		while (iterator1.hasNext()) {
			Entry entry = (Entry) iterator1.next();

			if (h2.containsKey(entry.getKey())) {
				inter = inter + Math.min((int) entry.getValue(), h2.get(entry.getKey()));
				union = union + Math.max((int) entry.getValue(), h2.get(entry.getKey()));
				h2.remove(entry.getKey());
			} else {
				union = union + (int) entry.getValue();
			}
		}

		Iterator iterator2 = h2.entrySet().iterator();
		while (iterator2.hasNext()) {
			Entry entry = (Entry) iterator2.next();
			union=union+(int)entry.getValue();
		}
		
		
		

		double result = (double) inter / (double) union;

		return (int) (result * (65536.0));
	}


	public HashMap<String, Integer> usado(String target) {

		HashMap<String, Integer> tmp = new HashMap<>();

		for (int i = 0; i < target.length() - 1; i++) {
			String data = "";
			char head = target.charAt(i);
			char tail = target.charAt(i + 1);

			if (head >= 'a' && head <= 'z') {
				if (tail >= 'a' && tail <= 'z') {

					data = "" + head + tail;

					if (tmp.containsKey(data)) {
						tmp.replace(data, tmp.get(data) + 1);
					} else
						tmp.put(data, 1);

				} else {
					continue;
				}
			} else
				continue;
		}

		return tmp;
	}

	public static void main(String[] args) {
		P5_hash p = new P5_hash();
		System.out.println(p.solution("E=M*C^2", "e=m*c^2"));
	}

}
