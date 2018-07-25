package round498_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String b= br.readLine();

        //solve
        System.out.println(solve(a,b));

    }

    private static int solve(String a, String b) {

        int result = 0;

        for (int i = 0; i < a.length()/2; i++) {
            int [] alp = new int[26];
            char af = a.charAt(i);
            char al = a.charAt(a.length()-1-i);
            char bf = b.charAt(i);
            char bl = b.charAt(b.length()-1-i);

            alp[af-'a']++;
            alp[al-'a']++;
            alp[bf-'a']++;
            alp[bl-'a']++;

            int count = 0;
            int check = 0;
            for (int j = 0; j < 26; j++) {
                if(count<alp[j])
                    count=alp[j];
                if(alp[j]==2)
                    check++;
            }

            if(count==1){
                result+=2;
            }else if(count==2){
                if(check!=2){

                    if(al==af)
                        result+=2;
                    else
                        result+=1;
                }
            }else if(count==3){
                result+=1;
            }else{ // count == 4
            }


        }

        if(a.length()%2==1){
            int mid = a.length()/2;
            char aa = a.charAt(mid);
            char bb = b.charAt(mid);

            if(aa!=bb)
                result+=1;
        }

        return result;
    }

}
