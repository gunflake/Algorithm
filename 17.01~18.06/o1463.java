//1로 만들기

import java.util.Scanner;

public class o1463 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int[] array = new int[num + 1];
        array[0] = 0;
        array[1] = 0;


        for (int i = 2; i <= num; i++) {
            if (i % 3 == 0) {
                array[i] = array[i / 3] + 1;
            } else if (i % 2 == 0) {
                if (array[i / 2] < array[i - 1])
                    array[i] = array[i / 2] + 1;
                else
                    array[i] = array[i - 1] + 1;
            } else {
                array[i] = array[i - 1] + 1;
            }
        }
        System.out.println(array[num]);

    }
}
