//2xn 타일 채우기

import java.util.Scanner;

public class o11726 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] array = new int[n];
		array[0]=1;
		array[1]=2;
				
		for (int i = 2; i < n; i++) {
			array[i]=(array[i-2]+array[i-1])%10007;
			
		}
		System.out.println(array[n-1]);

	}

}
