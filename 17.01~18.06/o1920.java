package october;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class o1920 {
	
	public static String binary(int[] store, int first, int last, int mid, int target) {
		
		if(first > last)
			return "0";
		
		if(target == store[mid])
			return "1";
		else if(target > store[mid]) {
			first = mid+1;
			mid = (first + last) / 2;
			return binary(store, first, last, mid, target);
		}else {
			last = mid-1;
			mid = (first+last)/2;
			return binary(store, first, last, mid, target);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int [] store = new int[n];
		
		int tmp=0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens())
			store[tmp++]=Integer.parseInt(st.nextToken());
			
		
		Arrays.sort(store);

		int count = Integer.parseInt(br.readLine());
		int [] target = new int[count];

		tmp=0;
		st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens())
			target[tmp++]=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<count;i++)
			bw.write(binary(store, 0, store.length-1, (store.length-1)/2, target[i])+"\n");


		bw.flush();
		bw.close();
		
		
	}

}
