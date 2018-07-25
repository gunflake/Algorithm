import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 2. 11..
 *
 * 문제 : 합분해
 */
public class o2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();           // a=n;
        int b = sc.nextInt();           // b=k;

        int[][] s = new int[a + 1][b + 3]; //   1<= n <= 200 , 1<= k <= 200

        for (int n = 1; n <= a; n++) {
            s[n][1] = 1;
            s[n][2] = n + 1;
        }

        for (int k = 1; k <= b; k++) {
            s[0][k] = 1; //k=0 or k=1 일때 반례없나 확인하기
            s[1][k] = k;
        }

        for (int k = 3; k <= b; k++) {
            for (int n = 2; n <= a; n++) {
                for (int m = 0; m <= n; m++) {
                    s[n][k]+=s[m][k-1];
                    s[n][k]%=1000000000;
                }
            }
        }

        System.out.println(s[a][b]);


    }
}
