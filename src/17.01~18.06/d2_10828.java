package algorithm;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by NamHyukMin on 2017. 5. 2..
 * stack 구현
 */
public class d2_10828 {
    static int stackData[] = new int[10000];
    static int size = 0;

    public static void push(int a) {
        stackData[size++] = a;
    }

    public static int pop() {
        if(size==0)
            return -1;
        else
            return stackData[--size];
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if(size==0)
            return 1;
        else
            return 0;
    }

    public static int top() {
        if(size==0)
            return -1;
        else
            return stackData[size-1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.skip("[\\r\\n]+");
        String[] command = new String[t];

        for (int i = 0; i < t; i++)
            command[i] = sc.nextLine();

        for (int i = 0; i < t; i++) {
            if (command[i].contains("push")) {
                StringTokenizer st = new StringTokenizer(command[i], " ");
                st.nextToken();
                push(Integer.parseInt(st.nextToken()));
            } else if (command[i].contains("pop")) {
                System.out.println(pop());

            } else if (command[i].contains("size")) {
                System.out.println(size());

            } else if (command[i].contains("empty")) {
                System.out.println(empty());

            } else if (command[i].contains("top")) {
                System.out.println(top());
            }

        }

    }
}
