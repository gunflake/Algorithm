//이동하기

import java.util.Scanner;

public class o11048 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int[][] in_array = new int[n][m];
		int[][] sum_array = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				in_array[i][j] = in.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (i == 0) { // n열 합 구하기
					if (j == 0)
						sum_array[i][j] = in_array[i][j];
					else
						sum_array[i][j] = in_array[i][j] + sum_array[i][j - 1];
				} else {
					if (j == 0) { // m열 합 구하기
						sum_array[i][j] = in_array[i][j] + sum_array[i - 1][j];
					}else{
						if(sum_array[i][j-1]>sum_array[i-1][j])
							sum_array[i][j]=sum_array[i][j-1]+in_array[i][j];
						else
							sum_array[i][j]=sum_array[i-1][j]+in_array[i][j];
					}
				}
			}
		}
		
		System.out.println(sum_array[n-1][m-1]);

	}

}
