package algorithm;

import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 5. 13..
 * 8단계 규칙찾기 - 부녀회장이 될꺼야
 */
public class d13_2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] input = new int[t][2];
        int max_floor = 0;
        int max_roomNo = 0;
        for (int i = 0; i < t; i++) {
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
            if (max_floor < input[i][0]) {
                max_floor = input[i][0];
            }
            if (max_roomNo < input[i][1])
                max_roomNo = input[i][1];
        }

        int[][] r = new int[t + 1][max_roomNo + 1];

        for (int i = 1; i <= max_roomNo; i++) {
            r[0][i] = i;
        }

        for (int i = 1; i <= max_floor; i++) {
            for (int j = 1; j <= max_roomNo; j++) {
                r[i][j] = r[i][j - 1] + r[i - 1][j];
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(r[input[i][0]][input[i][1]]);
        }


    }
}
