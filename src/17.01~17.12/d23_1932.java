import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 23..
 * 숫자 삼각형 DP문제
 */
public class d23_1932 {

    public static int[][] returnValue(int p[][],int d[][],int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                d[i][j]=p[i][j]+Math.max(d[i-1][j],d[i-1][j-1]);
            }
        }
        return d;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] p = new int[n+1][n+3];
        int [][] d = new int[n+1][n+3];

        for(int i=1;i<=n;i++) {
            for (int j = 1; j <= i; j++)
                   p[i][j] = sc.nextInt();
        }

        d = returnValue(p,d,n);

        int max = 0;
        for(int i=1;i<=n;i++)
            if(max<d[n][i])
                max=d[n][i];

        System.out.println(max);

    }
}
