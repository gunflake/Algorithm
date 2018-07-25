package october;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class o2309 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] hobit = new int[9];
		for (int i = 0; i < 9; i++)
			hobit[i] = Integer.parseInt(br.readLine());

		Arrays.sort(hobit);

		int sum = 0;
		int [] pass = new int [2];
		boolean flag = false;
		
		for (int i = 0; i < 9; i++)
			sum += hobit[i];

		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				if(sum - hobit[i] - hobit[j] == 100) {
					pass[0]=i;
					pass[1]=j;
					flag = true;
					break;
				}
			}
			if(flag)
				break;
		}
		
		for(int i=0;i<9;i++) {
			if(i==pass[0] || i== pass[1])
				continue;
			System.out.println(hobit[i]);
		}

	}
}
