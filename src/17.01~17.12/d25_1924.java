import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 25..
 * 2007년 요일 구하기
 */
public class d25_1924 {
    public static int returnDay(int x, int y){

        int count =0;
        int[] day = {31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=0;i<x-1;i++)
            count+=day[i];

        return count+y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        String[] st = new String[7];
        st[0]="SUN";
        st[1]="MON";
        st[2]="TUE";
        st[3]="WED";
        st[4]="TUR";
        st[5]="FRI";
        st[6]="SAT";

        System.out.println(st[(returnDay(x,y))%7]);
    }
}
