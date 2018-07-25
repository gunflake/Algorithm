package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class O2562 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [] max = new int[2];
		for(int i=1;i<=9;i++) {
			int n = Integer.parseInt(br.readLine());
			if(max[0]<n) {
				max[0]=n;
				max[1]=i;
			}
		}
		
		System.out.println(max[0]);
		System.out.println(max[1]);
		
	}

}
