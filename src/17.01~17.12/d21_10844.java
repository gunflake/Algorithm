import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 21..
 * Completed 2017. 4. 21, 쉬운 계단 수 (인접한 수 차이가 1씩 나는 문제)
 * 문제 조건값 확인 잘하자 ( SUM일 경우 항상 INTEGER 범위 초과 주위!! )
 */
public class d21_10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n+1][10];

        for (int i = 1; i < 10; i++)
            d[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0)
                    d[i][j] = d[i - 1][j + 1];
                else if (j == 9)
                    d[i][j] = d[i - 1][j - 1];
                else {
                    d[i][j] = d[i - 1][j + 1] + d[i - 1][j - 1];
                    d[i][j]%=1000000000;
                }
            }

        }

        int sum = 0;

        for(int i=0;i<=9;i++) {
            sum += d[n][i];
            sum%=1000000000;
        }

        System.out.println(sum);
    }

}
