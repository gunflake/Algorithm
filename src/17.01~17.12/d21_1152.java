import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by NamHyukMin on 2017. 4. 21..
 * 단어의 개수
 */
public class d21_1152 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        StringTokenizer st = new StringTokenizer(in, " ");
        System.out.println(st.countTokens());
    }
}
