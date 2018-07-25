import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class CCTV {
	int x;
	int y;
	int dir;
	int number;

	public CCTV(int x, int y, int dir, int number) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.number = number;
	}

}

public class Main {

	static int min = Integer.MAX_VALUE;
	static int[] dx = { 0, -1, 0, 1 }; //위, 왼쪽, 아래, 오른쪽  
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] board = new int[n][m];

		LinkedList<CCTV> list = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] >= 1 && board[i][j] <= 5) {
					list.add(new CCTV(j, i, -1, board[i][j])); // -1 방향 아직 안정함
				}
			}
		}

		// solve
		dfs(board, list, 0, list.size());
		System.out.println(min);

	}

	private static void dfs(int[][] board, LinkedList<CCTV> list, int now, int target) {
		if (now == target) {
			int[][] tmp = new int[board.length][board[0].length];

			copyArray(tmp, board); // board -> tmp 복사

			for (int i = 0; i < list.size(); i++) {
				cctvMoniter(list.get(i), tmp);
			}

			int count = countPlace(tmp);
			
			
			if (min > count)
				min = count;

			
			
			return;
		}

		for (int i = 0; i < 4; i++) {
			int tmp = list.get(now).dir;
			list.get(now).dir = i;

			dfs(board, list, now + 1, target);

			list.get(now).dir = tmp;
		}

	}

	private static void cctvMoniter(CCTV cctv, int[][] tmp) {
		if (cctv.number == 1) {
			directionMoniter(tmp, cctv.x, cctv.y, cctv.dir);
		} else if (cctv.number == 2) {
			directionMoniter(tmp, cctv.x, cctv.y, cctv.dir);
			directionMoniter(tmp, cctv.x, cctv.y, (cctv.dir+2)%4);
		} else if (cctv.number == 3) {
			directionMoniter(tmp, cctv.x, cctv.y, cctv.dir);
			directionMoniter(tmp, cctv.x, cctv.y, (cctv.dir+1)%4);
		} else if (cctv.number == 4) {
			directionMoniter(tmp, cctv.x, cctv.y, cctv.dir);
			directionMoniter(tmp, cctv.x, cctv.y, (cctv.dir+1)%4);
			directionMoniter(tmp, cctv.x, cctv.y, (cctv.dir+2)%4);
		} else if (cctv.number == 5) {
			directionMoniter(tmp, cctv.x, cctv.y, (cctv.dir)%4);
			directionMoniter(tmp, cctv.x, cctv.y, (cctv.dir+1)%4);
			directionMoniter(tmp, cctv.x, cctv.y, (cctv.dir+2)%4);
			directionMoniter(tmp, cctv.x, cctv.y, (cctv.dir+3)%4);
		}
	}

	private static void directionMoniter(int[][] tmp, int x, int y, int dir) { //dir 위, 왼쪽, 아래, 오른쪽
																				

		while (safeBoundary(tmp, x + dx[dir], y + dy[dir]) && tmp[y + dy[dir]][x + dx[dir]] != 6) { // 배열초과가 아니고, 장애물이
																									// 아닐때
			tmp[y + dy[dir]][x + dx[dir]] = 7;
			y += dy[dir];
			x += dx[dir];
		}

	}

	private static boolean safeBoundary(int[][] tmp, int x, int y) {
		if (x >= 0 && x < tmp[0].length && y >= 0 && y < tmp.length)
			return true;
		else
			return false;
	}

	private static void copyArray(int[][] tmp, int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				tmp[i][j] = board[i][j];
			}
		}
	}

	private static int countPlace(int[][] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 0)
					count++;
			}
		}

		return count;
	}

}
