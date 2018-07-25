package samsung;

/*
https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWHPkqBqAEsDFAUn&categoryId=AWHPkqBqAEsDFAUn&categoryType=CODE
 */


import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P3752 {


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

        Set<Integer> tmp = new HashSet<>();
        Set<Integer> answer = new HashSet<>();
        answer.add(0);
        
        for(int i=0;i<n;i++){

            for (int t: answer) {
                tmp.add(score[i]+t);
            }

            for(int a : tmp){
                answer.add(a);
            }
            
        }

        return answer.size();
        
    }


}
