package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class O10818 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		while(st.hasMoreTokens()) {
			int t = Integer.parseInt(st.nextToken());
			min = Math.min(min, t);
			max = Math.max(max, t);
		}
		
		System.out.println(min+" "+max);
	}

}
