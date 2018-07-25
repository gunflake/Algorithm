import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 18..
 * 순서쌍의 곱의 합
 */
public class d18_13900 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        long sum = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                sum += a[i] * a[j];
            }
        }

        System.out.println(sum);


    }
}
