package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Reverse_x5648 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<String> list = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n= Integer.parseInt(st.nextToken());

		for(int i=0;i<n;) {
			if(i>0)
				st = new StringTokenizer(br.readLine(), " ");
			
			while(st.hasMoreTokens()) {
				list.add(st.nextToken());
				i++;
			}
		}
		
		LinkedList<Long> result = reverse(list);
		
		result.sort(new Comparator<Long>() {
			@Override
			public int compare(Long l1, Long l2) {
				if(l1>l2)
					return 1;
				else if(l1<l2)
					return -1;
				else
					return 0;
			}
		});
		
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));
		
		
		
	}
	
	public static LinkedList<Long> reverse(LinkedList<String> list) {
		LinkedList<Long> result = new LinkedList<>();
		
		for(int i=0;i<list.size();i++) {
			result.add(Long.parseLong(new StringBuffer(list.get(i)).reverse().toString()));
		}
		
		return result;
	}
}
