package algorithm;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by NamHyukMin on 2017. 5. 1..
 * 음계 (6단계 1차원 배열 사용하기)
 */
public class d1_2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();


        StringTokenizer st = new StringTokenizer(input, " ");
        int s =Integer.parseInt(st.nextToken());
        if(s==1) {
            while (st.hasMoreTokens()) {
                if (s+1 == Integer.parseInt(st.nextToken()))
                    s++;
            }
            if (s == 8)
                System.out.println("ascending");
            else
                System.out.println("mixed");
        }else if(s==8){
            while (st.hasMoreTokens()) {
                if (s-1 == Integer.parseInt(st.nextToken()))
                    s--;
            }
            if (s == 1)
                System.out.println("descending");
            else
                System.out.println("mixed");
        }else{
            System.out.println("mixed");
        }

    }

}
