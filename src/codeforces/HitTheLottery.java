/*
 *	http://codeforces.com/contest/996/problem/A 
 */

package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HitTheLottery {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//solve
		System.out.println(solve(n));
		
	}

	private static int solve(int n) {
		int [] d = {1,5,10,20,100};
		
		int count = 0;
		int p = d.length-1;
		while(n>0) {
			int tmp = n/d[p];
			count+=tmp;
			n%=d[p];
			p--;
		}
		
		return count;
	}

}
