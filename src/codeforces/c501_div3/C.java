package codeforces.c501_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] dif = new int[n];
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            firstSum+=a;
            secondSum+=b;
            dif[i] = a-b;
        }

        System.out.println(solve(firstSum, secondSum, dif, m));

    }

    private static int solve(int firstSum, int secondSum, int[] dif, int m) {
        if(secondSum>m) {
            return -1;
        }else{
            Arrays.parallelSort(dif);
            int count = 0;
            for (int i = dif.length-1; i >=0 ; i--) {
                if(firstSum>m){
                    firstSum-=dif[i];
                    count++;
                }else{
                    return count;
                }
            }
            return count;
        }
    }
}