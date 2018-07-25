package algorithm;

import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 5. 14..
 * 8단계 규칙찾기 - 방번호
 */
public class d13_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String i = sc.nextLine();
        int[] n = new int[10];

        for (int j = 0; j < i.length(); j++) {
            n[i.charAt(j) - '0']++;
        }

        int max = 0;
        for (int j = 0; j < n.length - 1; j++) {

            if (j == 6)
                continue;
            if (max < n[j])
                max = n[j];
        }

        int result;

        if ((n[6] + n[9]) % 2 == 1)
            result = (n[6] + n[9]) / 2 + 1;
        else
            result = (n[6] + n[9]) / 2;

        if(max>result)
            System.out.println(max);
        else
            System.out.println(result);

    }


}
