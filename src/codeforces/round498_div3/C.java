package codeforces.round498_div3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //solve
        System.out.println(solve(n, arr));
    }

    private static long solve(int n, int[] arr) {

        if (n == 1) {
            return 0;
        } else if (n == 2) {
            if (arr[0] == arr[1])
                return arr[0];
        }

        int head = 1;
        int tail = n - 2;

        long max = 0;
        long head_sum = arr[0];
        long tail_sum = arr[n - 1];

        for (; head <= tail; ) {

            if (head_sum == tail_sum) {
                max = head_sum;
                head_sum += arr[head++];
            } else if (head_sum < tail_sum) {
                head_sum += arr[head++];
            } else {
                tail_sum += arr[tail--];
            }
        }
        if (head_sum == tail_sum) {
            max = head_sum;
        }

        return max;
    }

}