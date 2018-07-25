package september;

/*
 * O와 X로 채워진 표가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 
 * 표에서 O로 이루어진 가장 큰 정사각형을 찾아 넓이를 반환하는 findLargestSquare 
 * 함수를 완성하세요. 예를 들어
 */

class FindLargestSquare_DP {

	public int findLargestSquare(char[][] board) {
		int max = 0;
		int[][] dp = new int[board.length][board[0].length];

		dp = inputDp(board, dp);

		for (int y = 1; y < board.length; y++) {
			for (int x = 1; x < board[0].length; x++) {
				if (board[y][x] == 'O') {
					dp[y][x] = min(dp[y - 1][x], dp[y-1][x-1], dp[y][x - 1]) + 1;
					if (max < dp[y][x])
						max = dp[y][x];
				}
			}
		}
		return max * max;
	}

	public int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	public int[][] inputDp(char[][] board, int[][] dp) {
		for (int i = 0; i < board[0].length; i++) { // i = x
			for (int j = 0; j < board.length; j++) { // j = y
				if (board[j][i] == 'O')
					dp[j][i] = 1;
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		FindLargestSquare_DP test = new FindLargestSquare_DP();
		char [][]board ={
				{'X','O','O','O','X'},
				{'X','O','O','O','O'},
				{'X','X','O','O','O'},
				{'X','X','O','O','O'},
				{'X','X','X','X','X'}};

		System.out.println(test.findLargestSquare(board));
	}
}