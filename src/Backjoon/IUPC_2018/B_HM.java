package Backjoon.IUPC_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_HM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] head = new int[n];
        int [] body = new int[m];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            head[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            body[i]=Integer.parseInt(st.nextToken());
        }

        //solve

        System.out.println(solve(head, body));

    }

    private static int solve(int[] head, int[] body) {
        Arrays.sort(head);
        Arrays.sort(body);
        return head[head.length-1]+body[body.length-1];
    }
}
