package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P5 {
	
	public void sex(String[][] person) {
		
	}
	
	public void age() {
		
	}

	public void old() {
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String conditionRank=br.readLine();
		
		StringTokenizer st = new StringTokenizer(conditionRank, " ");
		

		int personNumber = Integer.parseInt(br.readLine());
		
		String [] tmp = new String[personNumber];
		String [][] peron = new String[personNumber][3];
		for(int i=0;i<personNumber;i++)
			tmp[i]=br.readLine();
		
		for(int i=0;i<personNumber;i++) {
			StringTokenizer sst =new StringTokenizer(tmp[i], " ");
			
			peron[i][0]=sst.nextToken();
			peron[i][1]=sst.nextToken();
			peron[i][2]=sst.nextToken();
		}
		
		HashMap<Integer, String> hash = new HashMap<>();
		hash.put(Integer.parseInt(st.nextToken()), "sex");
		hash.put(Integer.parseInt(st.nextToken()), "age");
		hash.put(Integer.parseInt(st.nextToken()), "old");
		
		
		
		
	}
	
	

}
