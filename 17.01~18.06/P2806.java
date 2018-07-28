import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	static int count; //각 테스트케이스의 총 가지수 

	public static void main(String[] args) throws NumberFormatException, IOException {

		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t= Integer.parseInt(br.readLine());
		
		
		for(int i=1;i<=t;i++) {
			int n = Integer.parseInt(br.readLine());
			count = 0; //초기화
			solve(n); 

			bw.write("#"+i+" "+count); //output
			bw.newLine();
		}
		
		bw.flush();
				
	}

	private static void solve(int n) {
		boolean [] checkLeft = new boolean[n+n]; // 
		boolean [] checkRight = new boolean[n+n];
		boolean [] row  = new boolean[n];
		dfs(n, checkLeft, checkRight,  0, row);
		
	}

	private static void dfs(int n, boolean[] checkLeft, boolean[] checkRight, int start, boolean[] row) {
		if(start==n) {
			count++;
			
			return;
		}
		
		for(int i=0;i<n;i++) {
			int diagonalLeft = i+start; // 대각선 /
			int diagonalRight = i-start+n; // 대각선 \
			
			if(!checkLeft[diagonalLeft]&& !checkRight[diagonalRight] && !row[i]) {//왼쪽, 오른쪽 , 열이 비어있으면 
				checkLeft[diagonalLeft] = true;
				checkRight[diagonalRight] = true;
				row[i] = true;
				
				dfs(n, checkLeft,checkRight, start+1, row);
				
				checkLeft[diagonalLeft] = false;
				checkRight[diagonalRight] = false;
				row[i] = false;
				
			}
			
			
		}
		
		
		
		
	}
}
