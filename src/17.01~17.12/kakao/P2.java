package kakao;


//1	1S2D*3T	37	11 * 2 + 22 * 2 + 33
//2	1D2S#10S	9	12 + 21 * (-1) + 101
//3	1D2S0T	3	12 + 21 + 03
//4	1S*2T*3S	23	11 * 2 * 2 + 23 * 2 + 31
//5	1D#2S*3S	5	12 * (-1) * 2 + 21 * 2 + 31
//6	1T2D3D#	-4	13 + 22 + 32 * (-1)
//7	1D2S3T*	59	12 + 21 * 2 + 33 * 2

public class P2 {

	public int solution(String str) {

		int count = 0;

		String[][] parse = new String[3][3];
		int[] result = new int[3];

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == 'D' || str.charAt(i) == 'S' || str.charAt(i) == 'T') {
				int j = i - 1;

				while (str.charAt(j) >= '0' && str.charAt(j) <= '9') {
					j--;
					if (j < 0)
						break;
				}

				parse[count][0] = str.substring(j + 1, i);
				parse[count][1] = "" + str.charAt(i);

				if (i + 1 != str.length())
					if (str.charAt(i + 1) == '*' || str.charAt(i + 1) == '#')
						parse[count][2] = "" + str.charAt(i + 1);

				count++;
			}

		}


		for (int i = 0; i < 3; i++)
			result[i] = value(parse[i]);

		for (int i = 0; i < 3; i++) {
			
			if(parse[i][2]==null)
				continue;

			if (parse[i][2].charAt(0) == '#') {
				result[i]*=-1;

			} else if (parse[i][2].charAt(0) == '*') {
				
				result[i]*=2;
				
				if(i>0)
					result[i-1]*=2;
				

			}

		}
		

		return result[0]+result[1]+result[2];
	}

	public int value(String[] s) {

		int score = Integer.parseInt(s[0]);

		if (s[1].charAt(0) == 'D')
			score = (int) Math.pow(score, 2);
		else if (s[1].charAt(0) == 'T')
			score = (int) Math.pow(score, 3);

		return score;

	}

	public static void main(String[] args) {
		P2 p = new P2();

		System.out.println(p.solution("1S2D*3T"));
	}

}
