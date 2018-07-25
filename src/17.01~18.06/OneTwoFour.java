package september;

import java.util.LinkedList;

/*
 * 1,2,4 세 개의 숫자만 쓰는 124나라가 있습니다.

 * 124나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
						
 * 10진법의 1 → 1     /	1   
 * 10진법의 2 → 2     /   2
 * 10진법의 3 → 4     /   10
 * 10진법의 4 → 11    /	11   
 * 10진법의 5 → 12		/	12
 * 10진법의 6 → 14		/	20
 * 10진법의 7 → 21		/	21
 * 10진법의 8 → 22		/	22
 * 10진법의 9 → 24		/   100
 * 10진법의 10 → 41	/	101
 * 		  11 -> 42  /    102 
 		  12 -> 44
 		  13 -> 111
 		  14 -> 112
 		  15 -> 114
 		  16 -> 121
 		  17 - >122
 		  18 ->124
 		  19 -> 141
 		  20 -> 142
 		  21 -> 144
 		  22 -> 211
 		  23 -> 212
 		  24 -> 214
 		  25 -> 221
 		  26 -> 222
 		  27 -> 224
 		  28 -> 241
 		  29 -> 242
 		  30 -> 244
 		  31 -> 411
 		  
 		  
 		  
 * 10진법의 수 N이 입력될 때, 124나라에서 쓰는 숫자로 변환하여 반환해주는 change124 함수를 완성해 보세요. 예를 들어 N = 10이면 “41”를 반환해주면 됩니다.
 * 리턴 타입은 문자열입니다.	 
 */

class OneTwoFour {
	public String change124(int n) {
		String answer = "";
		String result = "";

		LinkedList<Integer> alist = new LinkedList<>();

		int d = 0;
		
		alist.add(1);

		for (int i = 1; d < n; i++) {
			int tmp = 1;
			for (int j = 0; j < i; j++)
				tmp *= 3;
			
			alist.add(tmp);
			d=d+tmp;
		}

		
		d = d - alist.removeLast();

		// n=30
		n -= 1;
		int tmp = n - d; // 29-12 = 17

		for (int i = alist.size() - 1; i >= 0; i--) {
			int a = alist.removeLast(); // 9

			answer += String.valueOf(tmp / a); // tmp: 17/9=1 나머지 8
			tmp = tmp % a; // 17%9=8
		}

		for (int i = 0; i < answer.length(); i++) {
			result += change(answer.charAt(i));
		}

		return result;
	}

	public String change(char v) {
		if (v == '0')
			return "1";
		if (v == '1')
			return "2";
		if (v == '2')
			return "4";
		return "";
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		OneTwoFour oneTwoFour = new OneTwoFour();
		System.out.println(oneTwoFour.change124(1774838069));
	}
}
