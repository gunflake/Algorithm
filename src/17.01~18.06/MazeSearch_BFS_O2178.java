package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point1 {
	public int x;
	public int y;
	public int oldX;
	public int oldY;

	public Point1(int x, int y,  int oldX, int oldY) {
		super();
		this.x = x;
		this.y = y;
		this.oldX = oldX;
		this.oldY = oldY;
	}

}

public class MazeSearch_BFS_O2178 {

	static int result = Integer.MAX_VALUE;
	static int[][] board;
	static int n, m;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	

	public static void solve() {
		Queue<Point1> queue = new LinkedList<>();
		queue.add(new Point1(0, 0, -1, -1));

		while (!queue.isEmpty()) {
			Point1 t = queue.poll();
			
			if(t.x == n-1 && t.y==m-1)
				break;

			for(int i=0;i<4;i++) {
				
				int tx = t.x+dx[i];
				int ty = t.y+dy[i];
	
				if(tx>=0 && tx<n && ty>=0 && ty<m) { //IndexOutOfBoundary
					
					if(tx == t.oldX && ty == t.oldY) { //왔던 경로
						continue;
					}
					
					if(board[tx][ty]>1 || board[tx][ty]==0)
						continue;
					
					board[tx][ty]=board[t.x][t.y]+1;
					
					queue.add(new Point1(tx, ty, t.x, t.y));
				}
				
			}

		}

	}


	public static void main(String[] args) throws IOException {

		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = tmp.charAt(j) - '0';
			}
		}

		

		// solve
		solve();

		// output
		System.out.println(board[n-1][m-1]);

	}

}
