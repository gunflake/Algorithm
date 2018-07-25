package round498_div3;

import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(st.nextToken());
        }

        //solve
        solve(n, a);


    }

    private static void solve(int n, int[] a) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            if(a[i]%2==0){
                bw.write(a[i]-1+"");
            }else{
                bw.write(a[i]+"");
            }

            if(i!=n-1)
                bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
}
