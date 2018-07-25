import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 21..
 * 알파벳 찾기
 */
public class d21_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int p[] = new int[26];
        Arrays.fill(p, -1);

        for (int i = 0; i < input.length(); i++) {
            if (p[(int) input.charAt(i) - (int) 'a'] == -1)
                p[(int) input.charAt(i) - (int) 'a'] = i;
        }

        for(int i=0;i<p.length;i++)
            System.out.print(p[i]+" ");


    }
}
