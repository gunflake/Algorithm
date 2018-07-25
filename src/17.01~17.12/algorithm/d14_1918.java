package algorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by NamHyukMin on 2017. 5. 14..
 */
public class d14_1918 {

    public static Stack<Character> stack = new Stack<>();
    public static String result = "";

    public static void operator(char op) {
        while (true) {
            if (stack.isEmpty() || stack.peek() == '(' || ((op=='*'||op=='/') && (stack.peek()=='+' || stack.peek()=='-'))) {
                stack.add(op);
                break;
            }else
                result += stack.pop();
        }
    }

    public static void closeParenthese(){
        while(true){
            if(stack.peek()=='('){
                stack.pop();
                break;
            }else{
                result+=stack.pop();
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();


        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == ')') { // 괄호

                if (input.charAt(i) == '(') {
                    stack.add(input.charAt(i));
                } else{
                    closeParenthese();
                }

            } else if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {

                operator(input.charAt(i));

            } else { //알파벳
                result += input.charAt(i);
            }
        }

        while (!stack.isEmpty())
            result += stack.pop();
        System.out.println(result);

    }
}
