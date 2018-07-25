package leetcode;

public class P867 {

    static int [] digit = {0, 11, 101, 10301, 10301, 1003001, 1003001, 100000000, 100000000, 100000000, 100000000};

    public int primePalindrome(int N) {

        int length = String.valueOf(N).length();



        boolean [] check = new boolean[digit[length]+1];
        for (int i = 2; i <= digit[length]; i++) {


            for(int j=i+i;j<digit[length];j+=i){
                check[j]=true;
            }

            if(!check[i] && i>= N){
                if(palindrome(i))
                    return i;
            }
        }

        return -1;
    }

    private boolean palindrome(int n){
        String tmp =String.valueOf(n);
        boolean flag = true;
        int last = tmp.length()-1;
        for(int i=0;i<tmp.length();i++){
            if(tmp.charAt(i)!=tmp.charAt(last-i)){
                flag=false;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new P867().primePalindrome(102));
    }



}
