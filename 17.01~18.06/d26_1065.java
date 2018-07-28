import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 26..
 */
public class d26_1065 {

    public static boolean check(int a){
        int dif = a%10 - (a/10)%10;
        while(a>9){
            if(dif != a%10 - (a/10)%10)
                return false;
            a/=10;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if(check(i))
                count++;
        }
        System.out.println(count);
    }
}
