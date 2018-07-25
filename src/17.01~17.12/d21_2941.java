import java.util.Scanner;

public class d21_2941 {
    static String[] check = {"c=", "c-", "dz=", "d-", "lj","nj","s=","z="};

    public static String change(String a){
        for(int i=0;i<check.length;i++) {
            if (a.contains(check[i]))
                a = a.replace(check[i],"0");
        }
        return a;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        a= change(a);
        System.out.println(a.length());

    }
}