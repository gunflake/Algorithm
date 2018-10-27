package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        if(x<0)
            x*=-1;
        if(y<0)
            y*=-1;


        int g = gcd(x,y);


        if(x==0 && y==0){
            System.out.println(0);
            return;
        }

        if(g==1)
            System.out.println(1);
        else
            System.out.println(2);



    }


    public static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }

}
