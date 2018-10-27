package leetcode.contest100;

public class P899 {

    public String orderlyQueue(String S, int K) {

        String result = "";
        if (K == 1) {
            int t = 0;
            String sub = "";

            for (int i = 1; i < S.length(); i++) {
                if (S.charAt(t) > S.charAt(i)) {
                    t = i;
                    sub = S.substring(t);
                }
            }


            for (int i = 0; i < S.length(); i++) {
                if(S.charAt(i)==S.charAt(t)){
                    if(sub.compareTo(S.substring(i))>0){
                        sub = S.substring(i);
                        t=i;
                    }

                }

            }



            result = S.substring(t) + S.substring(0, t);

        } else {

            int [] alp = new int[26];

            for (int i = 0; i < S.length(); i++) {
                int tmp = S.charAt(i)-'a';
                alp[tmp]++;
            }

            for (int i = 0; i < 26; i++) {

                while(alp[i]>0){
                    char t = (char) ('a' + i);
                    result+=t;
                    alp[i]--;
                }

            }


        }


        return result;
    }

    public static void main(String[] args) {

        System.out.println(new P899().orderlyQueue("xitavoyjqiupzadbdyymyvuteolyeerecnuptghlzsynozeuuvteryojyokpufanyrqqmtgxhyycltlnusyeyyqygwupcaagtkuq",1));
    }

}
