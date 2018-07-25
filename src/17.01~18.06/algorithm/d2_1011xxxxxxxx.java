package algorithm;

import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 5. 2..
 * 규칙찾기 -- 광년 이동
 */
public class d2_1011xxxxxxxx {

    public static int playCount(int x, int y){
        int d = y-x;
        int sum=1;
        int count=2;

        while(sum*2<d){
            sum+=count++;
        }

        if(sum*2==d)
            return (count-1)*2;
        else
            return (count-2)*2+1;

    }

    public static void main(String[] arsgs){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] n = new int[t][2];
        for (int i = 0; i < n.length; i++) {
            n[i][0]=sc.nextInt();
            n[i][1]=sc.nextInt();
        }

        for (int i = 0; i < t; i++) {
            System.out.println(playCount(n[i][0],n[i][1]));
        }

    }
}
