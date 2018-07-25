package algorithm.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Omok_O2615 {

	static int[][] board;

	static int[] da = { -1, 1, 1, 0 }; //행
	static int[] db = { 1, 0, 1, 1 }; //열

	static int ra, rb;  //결과값 행, 열
	static int resultColor; //결과 색깔 

	public static void solve() {

		for (int a = 0; a < 19; a++) { //행
			for (int b = 0; b < 19; b++) { //열

				if (board[b][a] > 0) { //돌이 놓아진거면
					if (checkResult(b, a, board[b][a])) { //실질적인 검사 코드

						// 해당 좌표 결과값이 이긴 값이면 해당 x,y 좌표 기록하고 return!!
						resultColor = board[b][a];
						ra = b + 1;
						rb = a + 1;
						return;
					}

				}

			}
		}

		ra = rb = -1;
		resultColor = 0;

	}

	public static boolean checkResult(int pa, int pb, int color) { //검사코드 
		for (int i = 0; i < db.length; i++) { //방향 기울기 0, 45, 90, 135 도 
			int tmp = 1;
			tmp += bfs(pa+da[i], pb+db[i], da[i], db[i], color); //해당 방향으로 돌의 개수가 몇개인지...
			tmp += bfs(pa-da[i], pb-db[i], -da[i], -db[i], color); //해당 반대방향으로 돌의 개수가 몇개인지...
			
			if (tmp==5) { //돌의 개수가 5개면 결과 리턴
				return true;
			}
		}

		return false;

	}

	// 해당 방향으로 색깔이 같으면 +1 
	public static int bfs(int pa, int pb, int da, int db, int color) {

		if (!checkBound(pa, pb) || board[pa][pb] != color) {
			return 0;
		} else {
			return 1+bfs(pa+da, pb+db, da, db, color);
		}

	}


	// board 범위 벗어나는가
	public static boolean checkBound(int pa, int pb) {

		if (pa < 0 || pa >= 19 || pb < 0 || pb >= 19)
			return false;
		else
			return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		board = new int[19][19];
		StringTokenizer st;

		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// solve
		solve();
		if (resultColor == 0)
			System.out.println(0);

		else {
			System.out.println(resultColor);
			System.out.println(ra + " " + rb);
		}

	}

}
