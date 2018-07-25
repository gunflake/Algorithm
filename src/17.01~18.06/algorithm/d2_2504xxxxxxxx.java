package algorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by NamHyukMin on 2017. 5. 2..
 * stack 이용 괄호의 값 구하기
 */
public class d2_2504xxxxxxxx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        char[] check = {'(', ')', '[', ']'};
        Stack<Character> stack = new Stack<Character>();

        int count = 1;
        int midCount = 1;

        boolean confirm=true;

        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i)==check[0] || n.charAt(i) == check[2]){
                stack.push(n.charAt(i));
            }else if(n.charAt(i)==check[1]){
                if(stack.pop()==check[0]){

                }else
                    confirm=false;

            }else if(n.charAt(i) == check[3]){
                if(stack.pop()==check[2]){
                    count+=3;

                }else
                    confirm=false;
            }else
                confirm=false;
        }

        System.out.println(confirm);
        System.out.println(stack.empty());

    }
}
