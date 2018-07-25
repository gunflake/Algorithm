package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] e = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            e[i]=Integer.parseInt(st.nextToken());
        }


        System.out.println(solve(e, n));
        }
    private static int solve(int[] e, int n) {

        int [] len = new int[n];
        len[0]=1;

        for (int i = 1; i < e.length; i++) {
            int max = 0;
            for(int j=0;j<i;j++){
                if(e[i]>e[j]){
                    if(len[j]>max)
                        max=len[j];
                }
            }
            len[i]=max+1;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if(max<len[i])
                max=len[i];
        }

        return n-max;
    }
}
