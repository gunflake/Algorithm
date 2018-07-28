package october;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class o1764 {

	public static boolean solve(String[] list, String checkWord) { //이분탐색 (checkword가 검색하려는 단어)
		
		int first = 0;
		int end = list.length-1;
		int mid;
		int tmp;
		while(first<=end) {
			mid = (first+end)/2;
			tmp = checkWord.compareTo(list[mid]);
			
			if(tmp==0)
				return true;
			else if(tmp<0) {
				end = mid-1;
			}else if(tmp>0){
				first = mid+1;
			}

		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		
		//input 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String [] noHear = new String[n];
		String tmp;
		for(int i=0;i<n;i++)
			noHear[i]=br.readLine();
		
		Arrays.sort(noHear); //오름차순으로 정렬
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<m;i++) {
			tmp=br.readLine(); //보지못한사람 이름 입력
			if(solve(noHear, tmp)) { //이분탐색을 통해 안에 듣지못한사람이 있을경우 true
				list.add(tmp);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
			bw.write(list.get(i)+"\n");

		bw.flush();
		bw.close();
	}

}
