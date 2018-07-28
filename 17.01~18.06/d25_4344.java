import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 25..
 * 평균은 넘겠지 소수점 4번째 반올림
 */
public class d25_4344 {
    public static double returnPer(double[] a){
        double avg=0;
        double sum=0;
        double count = 0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }

        avg=sum/a.length;

        for (int i = 0; i < a.length; i++) {
            if(a[i]>avg)
                count++;
        }

        return count/a.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] c = new double[n][];
        int temp;
        for (int i = 0; i < n; i++) {
            temp=sc.nextInt();
            c[i] = new double[temp];
            for(int j=0;j<temp;j++)
                c[i][j]=sc.nextInt();
        }


        //output
        for (int i = 0; i < n; i++)
            System.out.printf("%.3f%%\n", returnPer(c[i])*100);


    }
}
