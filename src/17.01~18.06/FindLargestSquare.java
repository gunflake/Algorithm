package september;

/*
 * O와 X로 채워진 표가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 
 * 표에서 O로 이루어진 가장 큰 정사각형을 찾아 넓이를 반환하는 findLargestSquare 
 * 함수를 완성하세요. 예를 들어
 */

class FindLargestSquare {
	public int findLargestSquare(char[][] board) {
		int xLength = board[0].length;
		int yLength = board.length;
		int size = Math.min(xLength, yLength);

		for (int i = size; i > 0; i--) { 
			for (int x = 0; x <= xLength - i; x++) {
				for (int y = 0; y <= yLength - i; y++) {
					if (check(board, x, y, i)) { // check 값이 true면 사각형 크기 return (x,y)=위치
						return i*i;
					}
				}
			}
		}

		return 1;
	}

	public boolean check(char[][] board, int x, int y, int size) { // (x,y) = position
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[y + i][x + j] == 'X') {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		FindLargestSquare test = new FindLargestSquare();
		char[][] board = { { 'X', 'O', 'O', 'X', 'X' }, { 'X', 'O', 'O', 'O', 'O' }, { 'X', 'X', 'X', 'X', 'O' } };

		System.out.println(test.findLargestSquare(board));
	}
}