package dataStructure;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by NamHyukMin on 2017. 5. 14..
 */
public class Calculator {

    public static final int operator = 11;
    public static final int parentheses = 22;
    public static final int alphabet = 33;
    public static final int plus = 43;
    public static final int minus = 45;
    public static final int multiplier = 42;
    public static final int divider = 47;
    public static final int left_parentheses = 40;
    public static final int right_parentheses = 41;

    public static Stack<Character> operator_stack = new Stack<>();


    public static int match_Char(char a) { //String의 char를 연산자, 괄호, 알파벳으로 구분해주는 함수

        if (a == '+' || a == '-' || a == '*' || a == '/')
            return operator;
        else if (a == '(' || a == ')')
            return parentheses;
        else
            return alphabet;
    }

    public static String postfix_Notation(String input) { //input String을 후위표기법으로 바꿔주는 함수
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            if (match_Char(input.charAt(i)) == operator) { //연산자일 경우

                if (operator_stack.isEmpty())              //스택이 비어 있으면 연산자를 stack에 push한다
                    operator_stack.add(input.charAt(i));
                else {                                     //스택이 비어있지 않다면

                    if (input.charAt(i) == plus || input.charAt(i) == minus) {  //연산자가 '+' 혹은 '-' 일경우
                        if (operator_stack.peek() == divider
                                || operator_stack.peek() == multiplier) { //top이 '/' , '*' 일 경우
                            //'('혹은 emptyStack이 될때까지 stack의 연산자를 pop한 후 현재 연산자를 push한다

                            result += operator_stack.pop();
                            if (operator_stack.peek() == '+' || operator_stack.peek() == '-')
                                result += operator_stack.pop();

                            operator_stack.add(input.charAt(i));


                        } else {

                            result += operator_stack.pop();
                            operator_stack.add(input.charAt(i));


                        }
                    } else {                        //연산자가 '*', '/'일 경우 stack에 push한다
                        if (operator_stack.peek() == divider
                                || operator_stack.peek() == multiplier) {

                            result += operator_stack.pop();
                            operator_stack.add(input.charAt(i));

                        } else
                            operator_stack.add(input.charAt(i));
                    }
                }

            } else if (match_Char(input.charAt(i)) == parentheses) {

                if (input.charAt(i) == left_parentheses) //괄호가 '('면 스택에 추가
                    operator_stack.add(input.charAt(i));

                else if (input.charAt(i) == right_parentheses) { //괄호가 ')'이면
                    while (!operator_stack.isEmpty() || operator_stack.peek() != left_parentheses) { //'('을 만나기 전까지 pop한다
                        result += operator_stack.pop();
                    }
                    if (operator_stack.peek() == left_parentheses)
                        operator_stack.pop(); //'(' 괄호 제거
                }

            } else if (match_Char(input.charAt(i)) == alphabet) {
                result += input.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String postfix_str = postfix_Notation(input);

        while (!operator_stack.isEmpty())
            postfix_str += operator_stack.pop();
        System.out.println(postfix_str);

    }
}
