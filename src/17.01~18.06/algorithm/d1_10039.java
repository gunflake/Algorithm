package algorithm;

import java.util.Scanner;
/**
 * 평균점수 (6단계 1차원 배열 사용하기)
 */

public class d1_10039 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int [] s = new int[5];
        for (int i = 0; i < 5; i++) {
            s[i]=sc.nextInt();
            if(s[i]<40)
                s[i]=40;
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum+=s[i];
        }
        System.out.println(sum/5);


    }
}
