
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15684 - 사다리 조작
public class HandleLadder {

    int minCount = 4;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int H = Integer.parseInt(firstLine[2]);

        int [][] board = new int[H][N-1];

        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]) - 1;
            int b = Integer.parseInt(temp[1]) - 1;
            board[a][b] = 1;
        }

         System.out.println(new HandleLadder().getMinInstallLadderCount(board, H, N-1));
    }

    private int getMinInstallLadderCount(int[][] board, int R, int C) {

        // 1. 사다리를 설치한다. (0개부터 3개까지 설치한다)
        for (int i = 0; i < 4; i++) {
             installLadder(board, R, C, i, 0, 0); // 설치 목표 개수, 현재 설치 개수, 다음 설치 위치
        }

        // 2. 설치한 사다리로 자신의 번호를 찾아가는지 확인한다.

        return minCount == 4 ? -1 : minCount;
    }

    // 사다리 설치 DFS
    private void installLadder(int[][] board, int R, int C, int targetCount, int currentCount, int index) {
        // index가 배열 범위를 초과하거나, 사다리가 설치되었으면 종료
        if(index >= R*C || minCount != 4){
            return;
        }

        // 현재 설치된 사다리가 설치하려는 사다리 개수랑 맞으면 사다리 검증하기
        if(currentCount == targetCount){
            // 검증 자신의 사다리로 갈 수 있는지 확인하기

            // 자신의 번호가 나를 찾아 가는지 확인하기
            for (int i = 0; i < C; i++) {
                if(!findMyself(board, R, C, i)){
                    return;
                }
            }

            minCount = targetCount;
        }else{
            int a = index / C;
            int b = index % C;

            // 사다리 설치가 가능하면 설치하기
            if(isSafeBoundary(R,C,a,b) && isPossibleInstallPosition(board, R, C, a, b)) {
                board[a][b] = 1;
                installLadder(board, R, C, targetCount, currentCount + 1, index + 1);
                board[a][b] = 0;
            }

            // 사다리 설치 못하면 다음 인덱스 탐색
            installLadder(board, R, C, targetCount, currentCount, index + 1);
        }
    }

    // col이 자신의 col로 끝나는지 확인
    private boolean findMyself(int[][] board, int R, int C, int col) {

        int currentCol = col;

        for (int currentRow = 0; currentRow < R; currentRow++) {

            // 오른쪽에 사다리가 존재하면
            if(currentCol < C && board[currentRow][currentCol] == 1){
                currentCol++;
            }
            // 왼쪽에 사다리가 존재하면
            else if(currentCol >= 1 && board[currentRow][currentCol - 1 ] == 1){
                currentCol--;
            }
        }

        return currentCol == col;
    }

    // 해당 위치에 사다리를 놓을 수 있는지 확인
    private boolean isPossibleInstallPosition(int[][] board, int R, int C, int a, int b) {
        // 현재 위치에 사다리가 설치되면 안됨
        if(board[a][b] == 1)
            return false;

        // 왼쪽에 사다리가 설치되어있으면 안됨
        if(isSafeBoundary(R, C, a,b-1) && board[a][b-1] == 1)
            return false;

        // 오른쪽에 사다리가 설치되어있으면 안됨
        if(isSafeBoundary(R, C, a,b+1) && board[a][b+1] == 1)
            return false;

         return true;
    }

    // board[a][b]가 배열 범위를 벗어나는지 확인
    private boolean isSafeBoundary(int R, int C, int a, int b) {
        return a >= 0 && a < R && b >=0 && b < C;

    }

}
