package kakao;

import java.util.ArrayList;

public class P5 {
	
	
	
	public int solution(String str1, String str2) {

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		ArrayList<String> s1 = new ArrayList<>();
		ArrayList<String> s2 = new ArrayList<>();

		s1 = usado(s1, str1);
		s2 = usado(s2, str2);
		
		for(int i=0;i<s1.size();i++)
			System.out.print(s1.get(i)+" ");

		System.out.println();
		for(int i=0;i<s2.size();i++)
			System.out.print(s2.get(i)+" ");


		if (s1.size() > s2.size())
			return value(s1, s2);
		else
			return value(s2, s1);
	}

	public int value(ArrayList<String> large, ArrayList<String> small) {

		int inter = 0;
		int union = large.size();

		for (int i = 0; i < large.size(); i++) {
			String tmp = large.get(i);
			boolean flag = false;
			for (int j = 0; j < small.size(); j++) {
				if (small.get(j).equals(tmp)) {
					inter++;
					flag = true;
					break;
				}
			}
			if (!flag)
				union++;
		}

		double result = (double) inter / (double) union;

		return (int) (result * (65536.0));
	}

	public ArrayList<String> usado(ArrayList<String> list, String target) {

		for (int i = 0; i < target.length() - 1; i++) {
			char head = target.charAt(i);
			char tail = target.charAt(i + 1);

			if (head >= 'a' && head <= 'z') {
				if (tail >= 'a' && tail <= 'z') {
					list.add("" + target.charAt(i) + target.charAt(i + 1));
				} else {
					continue;
				}
			} else
				continue;
		}

		return list;
	}

	public static void main(String[] args) {
		P5 p = new P5();
		System.out.println(p.solution("aa1+aa2", "AAAA12"));
	}

}
