package september;

public class NextBigNumber {
	public int nextBigNumber(int n) {
		int count = 0;
		int tmp = n;
		while (n > 0) {
			if (n % 2 == 1)
				count++;
			n /= 2;
		}

		while (true) {
			if (next(++tmp) == count)
				break;
		}

		return tmp;
	}

	public int next(int n) {
		int count = 0;

		while (n > 0) {
			if (n % 2 == 1)
				count++;
			n /= 2;
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(Math.sqrt(100.0));
		
		// int n = 3;
		// System.out.println(Integer.bitCount(n));
	}

}
