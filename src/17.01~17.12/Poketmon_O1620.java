package algorithm.mid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Poketmon_O1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();
		String [] arr = new String[n+1];

		for (int i = 1; i <= n; i++) {
			String tmp = br.readLine();
			map.put(tmp, i);
			arr[i]=tmp;
		}

		for (int i = 0; i < m; i++) {
			String tmp = br.readLine();
			if(tmp.charAt(0)>='0' && tmp.charAt(0)<='9') {
				int t = Integer.parseInt(tmp);
				bw.write(arr[t]+"\n");
			}else {
				bw.write(map.get(tmp)+"\n");
			}
		}
		
		bw.flush();

	}

}
