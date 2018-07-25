package codeforces;

/*
    http://codeforces.com/contest/1000/problem/C
 */

import java.io.*;
import java.util.*;

public class CoveredPointsCount_TimeLimitted {
    public static void main(String[] args) throws IOException {
        //input
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("the-file-name.txt"));
        ////FileInputStream file = new FileInputStream("the-file-name.txt");


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] open = new long[n];
        long[] close = new long[n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            open[i] = Long.parseLong(st.nextToken());
            close[i] = Long.parseLong(st.nextToken());
        }

        //solve
        long[] result = solve(n, open, close);

        for (int i = 1; i <= n; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();


    }

    private static long[] solve(int n, long[] open, long[] close) {
        Arrays.sort(open);
        Arrays.sort(close);
        long[] result = new long[n + 1];

        int count = 1;
        int o = 1;
        int c = 0;
        long b = open[0];

        while (o < open.length && c < close.length) {

            if (open[o] <= close[c]) {

                int tmp = 0;
                while (o + 1 < open.length && open[o + 1] == open[o]) {
                    o++;
                    tmp++;
                }

                result[count] += open[o] - b;
                count = count + 1 + tmp;
                b = open[o];
                o++;
            } else {

                result[count] += close[c] - b + 1;
                b = close[c] + 1;
                c++;

                int tmp = 0;
                while (c < close.length && close[c] == close[c - 1]) {
                    c++;
                    tmp++;
                }
                count = count - 1 - tmp;

            }


        }

        while (c < close.length) {
            result[count] += close[c] - b + 1;
            b = close[c] + 1;
            c++;

            int tmp = 0;
            while (c < close.length && close[c] == close[c - 1]) {
                c++;
                tmp++;
            }
            count = count - 1 - tmp;
        }


        return result;
    }

}


