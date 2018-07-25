import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 21..
 * 문자열 반복
 */
public class d21_2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] n_int = new int[t];
        String[] n_str = new String[t];

        for (int i = 0; i < t; i++) {
            n_int[i] = sc.nextInt();
            n_str[i] = sc.next();
        }

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n_str[i].length(); j++) {
                for (int k = 0; k < n_int[i]; k++) {
                    System.out.print(n_str[i].charAt(j));
                }
            }
            System.out.println();
        }
    }
}
