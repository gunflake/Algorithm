package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Nastya_and_an_Array {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		HashSet<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<n;i++) {
			int t = Integer.parseInt(st.nextToken());
			if(t!=0)
				set.add(t);
		}
		
		System.out.println(set.size());
	}

}
