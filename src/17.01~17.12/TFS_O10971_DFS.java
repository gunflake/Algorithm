package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TFS_O10971_DFS {
	private static int[][] board;
	private static int minimum = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(n);

	}

	public static void solve(int n) {
		
		for(int i=0;i<n;i++) {
			boolean [] visited = new boolean[n];
			visited[i]=true;
			bfs(visited,  n, 0, 1, i, i);
		}
		
		System.out.println(minimum);

	}

	public static void bfs(boolean[] visited, int n, int sum, int cnt, int beforeV, int firstVisited) {
		if(cnt==n) {
			
			if(board[beforeV][firstVisited]==0)
				return;
			
			sum+=board[beforeV][firstVisited];
			
			if(minimum>sum)
				minimum=sum;
		}

		for(int i=0;i<n;i++) {
			if(!visited[i] && board[beforeV][i]!=0) {
				sum+=board[beforeV][i];
				visited[i]=true;
				bfs(visited, n, sum, cnt+1, i, firstVisited);
				
				sum-=board[beforeV][i];
				visited[i]=false;
			}
		}

	}


}
