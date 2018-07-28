import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 21..
 * completed 17.4.21
 * 이친수 문제
 */
public class d21_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d[][] = new long[n + 1][2];

        d[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0)
                    d[i][j] = d[i - 1][0] + d[i - 1][1];
                else
                    d[i][j] = d[i - 1][0];
            }
        }

        System.out.println(d[n][0] + d[n][1]);
    }

}
