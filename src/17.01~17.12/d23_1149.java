import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 23..
 * RGB 거리
 */

public class d23_1149 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[][] = new int[n+3][3];
        long d[][] = new long[n+3][3];

        for(int i=1;i<=n;i++){
            p[i][0] = sc.nextInt();
            p[i][1] = sc.nextInt();
            p[i][2] = sc.nextInt();
        }

        d[1][0]=p[1][0];
        d[1][1]=p[1][1];
        d[1][2]=p[1][2];

        d[2][0]=p[2][0]+Math.min(d[1][1],d[1][2]);
        d[2][1]=p[2][1]+Math.min(d[1][0],d[1][2]);
        d[2][2]=p[2][2]+Math.min(d[1][0],d[1][1]);

        for(int i=3;i<=n;i++){
            d[i][0]=p[i][0]+Math.min(d[i-1][1],d[i-1][2]);
            d[i][1]=p[i][1]+Math.min(d[i-1][0],d[i-1][2]);
            d[i][2]=p[i][2]+Math.min(d[i-1][0],d[i-1][1]);
        }

        long result = 0;
        result = Math.min(d[n][0],d[n][1]);
        result = Math.min(result,d[n][2]);

        System.out.println(result);

    }
}
