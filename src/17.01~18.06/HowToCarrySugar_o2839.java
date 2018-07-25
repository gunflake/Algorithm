package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowToCarrySugar_o2839 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(solve(n));
	}

	private static int solve(int n) {
		int result = -1;
		
		int maxIf = n/5;
		
		for(int i=maxIf;i>=0;i--) {
			int carry = i * 5;
			int rest = n-carry;
			if(rest%3==0) {
				result=(rest/3)+i;
				break;
			}
			
		}
		
		return result;
	}

}
