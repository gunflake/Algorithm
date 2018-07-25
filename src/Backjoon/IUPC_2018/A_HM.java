package Backjoon.IUPC_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_HM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine().trim());
        int [] multi = new int[k];
        for (int i = 0; i < k; i++) {
            multi[i]=Integer.parseInt(st.nextToken());
        }

        //solve
        if(solve(n,multi)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }

    private static boolean solve(int n, int[] multi) {
        int count = 0;
        for (int i = 0; i < multi.length; i++) {
            if(multi[i]%2==1){
                count+=(multi[i]/2+1);
            }else{
                count+=multi[i]/2;
            }
        }
        if(count>=n)
            return true;
        else
            return false;
    }
}
