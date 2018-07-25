import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 21..
 * completed 2017.4.21 오르막 수 (자리가 오름 차순)
 */
public class d21_11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n + 1][10];

        Arrays.fill(d[1], 1);

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    d[i][j]=(d[i][j]+d[i-1][k])%10007;
                }
            }
        }

        int sum=0;
        for(int i=0;i<10;i++){
            sum+=d[n][i];
            sum%=10007;
        }
        System.out.println(sum);

    }
}
