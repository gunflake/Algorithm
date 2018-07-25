package algorithm;

import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 5. 1..
 * 분수 찾기 (8단계 규칙찾기)
 */
public class d1_1193 {
    public static int returnSum(int a){
        int sum=0;
        for (int i = 1 ; i <= a; i++) {
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum= 1;
        int count = 1;
        int a,b;
        String result;

        while(sum<n){
            sum+=++count;
        }

        if(count%2==0){
            a=n-returnSum(count-1);
            result=a+"/";
            b=count+1-a;
            result+=b;
        }else{
            a=returnSum(count)-n+1;
            result=a+"/";
            b=count+1-a;
            result+=b;
        }

        System.out.println(result);

    }
}
