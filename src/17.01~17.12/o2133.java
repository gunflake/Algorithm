import java.util.Scanner;

//타일채우기

public class o2133 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;

        int[] s = new int[32];

        s[0] = 1;
        s[2] = 3;

        for (int i = 4; i <= n; i += 2) {

            for (int j = 0; j <= i - 4; j += 2) {
                s[i] = s[i] + s[j];
            }
            s[i] = 2 * s[i] + 3 * s[i - 2];

        }

        System.out.println(s[n]);

    }
}
