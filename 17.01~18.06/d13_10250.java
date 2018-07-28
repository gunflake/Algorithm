package algorithm;

import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 5. 13..
 * 8단계 규칙찾기 - ACM 호텔
 */
public class d13_10250 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int [][] hwn = new int[t][3];

        int floor;
        int room_number;

        for (int i = 0; i < t; i++) {
            hwn[i][0]=sc.nextInt();
            hwn[i][1]=sc.nextInt();
            hwn[i][2]=sc.nextInt();
        }

        for (int i = 0; i < t; i++) {

            room_number = 1;

            while(hwn[i][2]>hwn[i][0]){
                hwn[i][2]-=hwn[i][0];
                room_number++;
            }

            floor=hwn[i][2];


            if(room_number<10)
                System.out.println(floor+"0"+room_number);
            else
                System.out.println(floor+""+room_number);
        }

    }
}
