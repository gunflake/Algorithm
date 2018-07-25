import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 2. 14..
 * 문제: 터렛 (원 2개 접점 구하기
 */
public class o1002 {

    public static double instance(int x1, int x2, int y1, int y2) {
        int d = (y1 - x1) * (y1 - x1) + (y2 - x2) * (y2 - x2);
        return Math.pow(d, 0.5);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int a[][] = new int[number][3];
        int b[][] = new int[number][3];
        int result[] = new int[number];

        for (int n = 0; n < number; n++) {
            for (int j = 0; j < 3; j++) {
                a[n][j] = sc.nextInt();
            }
            for (int j = 0; j < 3; j++) {
                b[n][j] = sc.nextInt();
            }
        }

        double d = 0;

        int max = 0, min = 0;
        for (int n = 0; n < number; n++) {
            d = instance(a[n][0], a[n][1], b[n][0], b[n][1]);


            if (d > a[n][2] + b[n][2])
                result[n] = 0;
            else if (d == a[n][2] + b[n][2])
                result[n] = 1;
            else {


                min = Math.min(a[n][2], b[n][2]);
                max = Math.max(a[n][2], b[n][2]);

                if (a[n][2] == b[n][2] && a[n][1] == b[n][1] && a[n][0] == b[n][0])
                    result[n] = -1;
                else {
                    if (d + min > max)
                        result[n] = 2;
                    else if (d + min == max)
                        result[n] = 1;
                    else
                        result[n] = 0;
                }


            }
        }


        for (int n = 0; n < number; n++)
            System.out.println(result[n]);

    }
}
