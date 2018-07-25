import java.util.Scanner;

/**
    17.04.20 목
    붕어빵 판매하기, DP문제
*/

public class d20_11052 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n+1];
        int[] t = new int[n+1];

        for(int i=1;i<=n;i++)
            p[i]=sc.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                t[i]=Math.max(t[i],p[j]+t[i-j]);
            }
        }
        System.out.println(t[n]);

    }

}
