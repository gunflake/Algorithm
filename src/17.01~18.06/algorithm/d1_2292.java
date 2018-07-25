package algorithm;

import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 5. 1..
 * 벌집 (8단계 규칙찾기)
 */
public class d1_2292 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum=1;
        int count = 1;
        while(sum<n){
            sum+=6*count++;
        }
        System.out.println(count);
    }
}
