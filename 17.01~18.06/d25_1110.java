import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 25..
 * 더하기 싸이클(좋은 문제)
 */
public class d25_1110 {
    public static int cycle(int a){
        int sum=0;
        int newN=0;

        sum=a/10+a%10;
        sum%=10;
        return newN = (a%10)*10+sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = cycle(n);
        int count = 1;


        while (n != result) {
            result = cycle(result);
            count++;
        }
        System.out.println(count);
    }

}