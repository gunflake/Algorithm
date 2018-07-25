package september;

class Hopscotch {
	int hopscotch(int[][] s, int size) {
		int[][] d = new int[s.length+1][4];

		d[0][0] = s[0][0];
		d[0][1] = s[0][1];
		d[0][2] = s[0][2];
		d[0][3] = s[0][3];
		
		for(int i=1;i<s.length;i++) {
			d[i][0]=s[i][0]+max(d[i-1][1],d[i-1][2],d[i-1][3]);
			d[i][1]=s[i][1]+max(d[i-1][0],d[i-1][2],d[i-1][3]);
			d[i][2]=s[i][2]+max(d[i-1][0],d[i-1][1],d[i-1][3]);
			d[i][3]=s[i][3]+max(d[i-1][1],d[i-1][2],d[i-1][0]);
		}
		return maxDP(d[s.length-1][0], d[s.length-1][1], d[s.length-1][2], d[s.length-1][3]);
	}
	public int maxDP(int a, int b, int c,int d) {
		return Math.max(Math.max(Math.max(a, b), c), d);
	}
	public int max(int x, int y, int z) {
		return Math.max(Math.max(x, y), z);
	}

	public static void main(String[] args) {
		Hopscotch c = new Hopscotch();
		int[][] test = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(c.hopscotch(test, 3));
	}

}