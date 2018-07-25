package july;

public class Text {

	static int[] memo = new int[20];

	public static void main(String[] args) {
		System.out.println(div(10));
	}

	public static int div(int n) {
		if (n == 1) {
			return 0;
		}
		
		if(memo[n]>0) 
			return memo[n];
		
		memo[n]=div(n-1)+1;
		
		if (n % 3 == 0) {
			int temp = div(n/3)+1;
			if(temp<memo[n])
				memo[n]=temp;
		}
		if (n % 2 == 0) {
			int temp = div(n/2)+1;
			if(temp<memo[n]) 
				memo[n]=temp;
		}

		return memo[n];

	}

}
