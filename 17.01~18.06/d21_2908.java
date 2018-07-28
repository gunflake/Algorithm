import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 21..
 * 상수 (문자열 리버스 후 크기 비교)
 */
public class d21_2908 {

    public static int reverse(String a){
        StringBuilder sb = new StringBuilder(a);
        return Integer.parseInt(sb.reverse().toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        String b = sc.next();

        int x = reverse(a);
        int y = reverse(b);

        if(x>y)
            System.out.println(x);
        else
            System.out.println(y);


    }
}

