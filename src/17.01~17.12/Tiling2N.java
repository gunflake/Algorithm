package september;

public class Tiling2N {
	public int tiling(int n) {
		int[] d = new int[n + 3];

		d[1] = 1;
		d[2] = 2;

		for (int i = 3; i <= n; i++) {
			d[i] = d[i - 2] + d[i - 1];
			
			if(d[i]>99999)
				d[i]%=100000;
		}
			return d[n];
	}

	public static void main(String args[]) {
		Tiling2N tryHelloWorld = new Tiling2N();
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.print(tryHelloWorld.tiling(3));
	}

}
