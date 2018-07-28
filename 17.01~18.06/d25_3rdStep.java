import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 25..
 */
public class d25_3rdStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();

        for (int i = 0; i < a.length(); i++) {
            if (i != 0)
                if (i % 10 == 0)
                    System.out.println();
            System.out.print(a.charAt(i));
        }


    }
}
