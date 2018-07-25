import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 21..
 * completed 17.4.21 포도주 시식
 */
public class d21_2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n + 3];
        int[] p = new int[n + 3];


        for (int i = 1; i <= n; i++)
            p[i] = sc.nextInt();

        d[1] = p[1];
        d[2] = p[1] + p[2];

        for (int i = 3; i <= n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + p[i]);
            d[i] = Math.max(d[i], d[i-3]+p[i]+p[i-1]);
        }

        System.out.println(d[n]);
    }
}
