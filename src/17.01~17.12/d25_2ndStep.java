import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 25..
 */
public class d25_2ndStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int max5kg = n/5;
        int result = -1;

        for (int i = max5kg; i >= 0 ; i--) {
            if((n-(i*5))%3==0){
                result=i+(n-(i*5))/3;
                break;
            }
        }

        System.out.println(result);


    }
}
