package algorithm.mid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 단지 번호 붙이기 (그래프 문제) - DFS를 이용해서 풀음
 */

class Point{
	public int x;
	public int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class MoleTunnel_BFS_O2667 {

	static Queue<Point> queue;
	static int[][] board;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,-1,0,1};

	public static int[] solve(int n) {
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					bfs(i, j, n, ++cnt);
				}
			}
		}
		
		int [] result = new int[cnt-1];
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j]>0)
					result[board[i][j]-2]++;
			}
		}
		
		return result;
		
	}
	

	private static void bfs(int x, int y, int n, int cnt) {
		
		board[x][y]=cnt;
		
		inputQueue(x,y,n);
		
		while(!queue.isEmpty()) {
			Point tmp = queue.poll();
			board[tmp.x][tmp.y]=cnt;
			inputQueue(tmp.x, tmp.y, n);
		}
	}

	private static void inputQueue(int x, int y, int n) {

		for(int i=0;i<4;i++)
			if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 &&y+dy[i]<n &&board[x+dx[i]][y+dy[i]]==1) 
				queue.add(new Point(x+dx[i], y+dy[i]));
				
		
	}

	public static void main(String[] args) throws IOException {

		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();

			for (int j = 0; j < tmp.length(); j++)
				board[i][j] = tmp.charAt(j) - '0';
		}

		
		

		
		
		// solve
		queue = new LinkedList<>();
		int [] result = solve(n);
		
		Arrays.sort(result);
		
		bw.write(result.length+"\n");
		for(int i=0;i<result.length;i++)
			bw.write(result[i]+"\n");
		
		bw.flush();
		
		

	}
}
