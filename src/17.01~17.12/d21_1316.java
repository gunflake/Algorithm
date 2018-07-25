import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 21..
 * 그룹 단어 체커
 */
public class d21_1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = n;
        String[] str = new String[n];

        for (int i = 0; i < str.length; i++)
            str[i] = sc.next();


        for (int i = 0; i < str.length; i++) {
            int alp[] = new int[27];
            for (int j = 0; j < str[i].length() - 1; j++) {
                alp[str[i].charAt(j) - 'a']++;
                if (str[i].charAt(j) != str[i].charAt(j + 1))
                    if (alp[str[i].charAt(j+1) - 'a'] != 0) {
                        count--;
                        break;
                    }
            }
        }
        System.out.println(count);
    }
}
