import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 2. 10..
 * 문제 : 1,2,3 더하기
 */


public class o9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int r[] = new int[number];
        int max=0;
        for (int i = 0; i < number; i++) {
            r[i] = sc.nextInt();
            if(r[i]>max)
                max=r[i];
        }

        int[] s = new int[max + 4];

        s[1] = 1;
        s[2] = 2;
        s[3] = 4;

        for (int n = 4; n <= max; n++) {
            s[n] = s[n - 1] + s[n - 2] + s[n - 3];
        }

        for (int i = 0; i < number; i++)
            System.out.println(s[r[i]]);


    }
}
