package october;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class o1921_hash {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		HashSet<Integer> store = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens())
			store.add(Integer.parseInt(st.nextToken()));
			
		
		int count = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens()) {
			if(store.contains(Integer.parseInt(st.nextToken())))
				bw.write("1\n");
			else
				bw.write("0\n");
			
		}
		
		bw.flush();
		
	}

}
