package samsung;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
    https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWLL3yk6ALUDFAUW
 */

public class P4259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] var = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());


            for (int j = 0; st.hasMoreTokens(); j++) {
                var[j] = Integer.parseInt(st.nextToken());
            }

            BigInteger b = solve(var, n);
            bw.write("#"+i+" "+b);
            if(i!=t)
                bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    private static BigInteger solve(int[] var, int n) {
        BigInteger result  = BigInteger.valueOf(0);
        int [] exponent = new int[n];
        int [] base = new int[n];

        for(int i=0;i<n;i++){
            exponent[i]=var[i]%10;
            base[i]=var[i]/10;
        }

        for (int i = 0; i < n; i++) {
            result = result.add(BigInteger.valueOf(base[i]).pow(exponent[i]));
        }


        return result;
    }

}
