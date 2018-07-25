package algorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by NamHyukMin on 2017. 5. 14..
 */
public class d15_2504 {
    public static int temp = 0;
    public static int sum = 0;
    public static int temp_sum = 0;
    public static Stack<Character> stack = new Stack<>();
    public static Stack<Integer> stack_temp = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '(' || in.charAt(i) == '[') {
                if (!stack.isEmpty()) {
                    stack_temp.add(temp);
                }
                temp = 0;
                stack.push(in.charAt(i));

            } else {
                if (in.charAt(i) == ')') {


                    stack.pop();

                    if (stack.isEmpty()) {
                        while (!stack_temp.isEmpty())
                            temp_sum += stack_temp.pop();

                        temp_sum+=temp;
                        sum+=temp_sum*2;
                        temp_sum=0;

                    }else {

                        if (temp == 0)
                            temp = 2;
                        else {
                            temp *= 2;
                        }
                    }






                } else {

                    stack.pop();

                    if (stack.isEmpty()) {
                        while (!stack_temp.isEmpty())
                            temp_sum += stack_temp.pop();

                        temp_sum+=temp;
                        sum+=temp_sum*3;
                        temp_sum=0;

                    }else {

                        if (temp == 0)
                            temp = 3;
                        else {
                            temp *= 3;
                        }
                    }

                }
            }


        }

        System.out.println(sum);


    }
}
