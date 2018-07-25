/**
 * Created by NamHyukMin on 2017. 4. 26..
 * 셀프 넘버
 */
public class d26_4673 {
    public static int selfNumber(int a){
        int sum = a;
        while(a>0){
            sum+=a%10;
            a/=10;
        }

        return sum;

    }
    public static void main(String[] args) {
        boolean [] check = new boolean[10001];
        int t=0;

        for (int i = 1; i < 10001; i++) {
            if(check[i]==false) {
                System.out.println(i);
                t = i;
                while(t<=10000){
                    t = selfNumber(t);
                    if(t<=10000)
                        check[t]=true;
                }
            }
        }

    }
}
