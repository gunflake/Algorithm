import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by NamHyukMin on 2017. 4. 21..
 * 다이얼 전화걸기 문제
 */
public class d21_5622 {
    static String str[] = {"ABC", "DEF","GHI","JKL", "MNO","PQRS","TUV","WXYZ"};

    public static int change(char a){
        int temp=0;
        for(int i=0;i<8;i++){
            if(str[i].contains(String.valueOf(a)))
                temp = i+3;
        }
        return temp;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        int sum=0;
        for(int i=0;i<a.length();i++){
            sum+=change(a.charAt(i));
        }
        System.out.println(sum);
    }

}
