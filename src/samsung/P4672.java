package samsung;

/*
    https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWRKNev6fqYDFAV8&categoryId=AWRKNev6fqYDFAV8&categoryType=CODE

 */

import java.io.*;

public class P4672 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = Integer.parseInt(br.readLine());


        for (int i = 1; i <= t; i++) {
            String input = br.readLine();
            int tmp = solve(input);
            bw.write("#" + i + " " + tmp);
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    private static int solve(String input) {

        count = 0;

        for (int i = 1; i <= input.length(); i++) { //i = Substring length
            String tmp = "";
            for (int j = 0; j < input.length(); j++) {
                tmp = subStringCreate(input, j, i);
                if(tmp!=null && pellindromOkay(tmp)){
                    count++;
                }


            }

        }

        return count;
    }

    private static void subStringDFS(String input, String subString, int length, int currentLength, int position) {
        if (currentLength == length) {
            if (pellindromOkay(subString))
                count++;
            return;
        }

        for (int i = position; i < input.length(); i++) {

            subStringDFS(input, subString + input.charAt(i), length, currentLength+1, i+1);

        }

    }

    private static boolean pellindromOkay(String tmp) {
        String p = "";
        for (int i = tmp.length() - 1; i >= 0; i--) {
            p += tmp.charAt(i);
        }
        if (tmp.equals(p))
            return true;
        else
            return false;
    }

    private static String subStringCreate(String input, int position, int length) {
        if (position + length <= input.length()) {
            return input.substring(position, position + length);
        } else {
            return null;
        }
    }
}
