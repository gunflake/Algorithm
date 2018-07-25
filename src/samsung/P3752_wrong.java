package samsung;

/*
https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWHPkqBqAEsDFAUn&categoryId=AWHPkqBqAEsDFAUn&categoryType=CODE
 */


        import java.io.*;
        import java.util.HashSet;
        import java.util.Set;
        import java.util.StringTokenizer;

public class P3752_wrong {

    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = Integer.parseInt(br.readLine());


        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] score = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; st.hasMoreTokens(); j++) {
                score[j] = Integer.parseInt(st.nextToken());
            }

            int tmp = solve(score, n);
            bw.write("#" + i + " " + tmp);
            if(i!=t)
                bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    private static int solve(int[] score, int n) {
        set = new HashSet<>();

        for (int i = 1; i <= n; i++) { // 개수 조합 > comNumber
            scoreDFS(score, i, 0, 0, 0); // score[], comNumber, currentCount, position, value

        }


        return set.size()+1;
    }

    private static void scoreDFS(int[] score, int comNumber, int currentCount, int position, int value) {
        if (comNumber == currentCount) {
            set.add(value);
            return;
        }

        for (int i = position; i < score.length; i++) {

            scoreDFS(score, comNumber, currentCount+1, i+1, value+score[i]);


        }

    }



}
