package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Divisor_o2501 {

	static public int divisor(int n, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i * i<= n; i++) {
			if (n % i == 0) {
				list.add(i);
			}
		}

		int tmp=0;
		
		for(int i=list.size()-1 ; i>=0 ; i--) {
			tmp=list.get(i);
			if(i==list.size()-1) {
				if(tmp*tmp!=n)
					list.add(n/tmp);
			}else {
				list.add(n/tmp);
			}
		}

		if (k > list.size())
			return 0;
		else
			return list.get(k - 1);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		System.out.println(divisor(n, k));
	}
}
