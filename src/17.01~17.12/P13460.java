import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Ball {
	int redX;
	int redY;
	int blueX;
	int blueY;
	int count = 0;
	
	public Ball(int redX, int redY, int blueX, int blueY, int count) {
		super();
		this.redX = redX;
		this.redY = redY;
		this.blueX = blueX;
		this.blueY = blueY;
		this.count = count;
	}

	

}

public class Main {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		char[][] board = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];

		int[] red = new int[2]; // (x, y)
		int[] blue = new int[2]; // x, y

		for (int i = 0; i < board.length; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = tmp.charAt(j);
				if (tmp.charAt(j) == 'B') {
					blue[0] = j;
					blue[1] = i;
				}

				if (tmp.charAt(j) == 'R') {
					red[0] = j;
					red[1] = i;
				}
			}
		}

		boolean [][][][] checkPosition = new boolean[11][11][11][11];
		
		// solve
		Queue<Ball> queue = new LinkedList<>();
		queue.add(new Ball(red[0], red[1], blue[0], blue[1], 0));
		boolean flag = false;

		while (!queue.isEmpty() ) {
			if (flag)
				break;
			Ball c = queue.poll();

			for (int i = 0; i < 4; i++) {

				int rCount = 0;
				int bCount = 0;

				int rx = c.redX;
				int ry = c.redY;
				int bx = c.blueX;
				int by = c.blueY;

				while (board[ry + dy[i]][rx + dx[i]] != '#' && board[ry + dy[i]][rx + dx[i]] != 'O') {
					rx += dx[i];
					ry += dy[i];
					rCount++;
				}

				while (board[by + dy[i]][bx + dx[i]] != '#' && board[by + dy[i]][bx + dx[i]] != 'O') {
					bx += dx[i];
					by += dy[i];
					bCount++;
				}

				if (rx == bx && ry == by) { // blue = red
					if (board[by + dy[i]][bx + dx[i]] == 'O') {
						continue;
					}

					if (rCount > bCount) {
						rx -= dx[i];
						ry -= dy[i];
					} else {
						bx -= dx[i];
						by -= dy[i];
					}
				}

				if (board[by + dy[i]][bx + dx[i]] == 'O') { // blue hall
					continue;
				}

				if (board[ry + dy[i]][rx + dx[i]] == 'O') {
					System.out.println(c.count + 1);
					return;
				}

				if (rx == c.redX && ry == c.redY && bx == c.blueX && by == c.blueY)
					continue;

				if(checkPosition[rx][ry][bx][by])
					continue;

				if(c.count<9) {
					checkPosition[rx][ry][bx][by]=true;
					queue.add(new Ball(rx, ry, bx, by, c.count + 1));
				}
			}

		}

		System.out.println(-1);

	}

}
