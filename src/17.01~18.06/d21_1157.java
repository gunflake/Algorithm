import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 21..
 * 단어 공부
 */
public class d21_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = new String();
        in = sc.next();
        int[] alp = new int[27];
        in = in.toUpperCase();

        for (int i = 0; i < in.length(); i++) {
            alp[(int) in.charAt(i) - (int) 'A'] += 1;
        }

        int max=0;
        int pos=-1;

        for(int i=0;i<alp.length;i++) {
            if (max < alp[i]) {
                max = alp[i];
                pos = i;
            }
        }

        Arrays.sort(alp);
        if(alp[alp.length-1] == alp[alp.length-2])
            System.out.println('?');
        else
            System.out.println((char)('A'+pos));

    }
}
