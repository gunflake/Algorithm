package round498_div3;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }


        int [] result_arr = new int[k];
        //solve
        LinkedList<Integer> list = new LinkedList<>();
        maxProfit(arr, k, 0, -1, 0, 0, list, result_arr);

        //output
        bw.write(result+"");
        bw.newLine();
        for (int i = 0; i < result_arr.length; i++) {
            bw.write(result_arr[i]+"");
            if(i!=result_arr.length)
                bw.write(" ");
        }
        bw.flush();
        bw.close();



    }

    public static void maxProfit(int[] arr, int goal_k, int cur_k, int position_before, int position, int total, LinkedList<Integer> list, int[] result_arr){
        if(cur_k==goal_k && position==arr.length){
            if(total>result){
                result=total;

                result_arr[0] = list.get(0)+1;
                for (int i = 1; i < result_arr.length; i++) {
                    result_arr[i] = list.get(i)-list.get(i-1);
                }

            }

            return;
        }else if(goal_k-cur_k > arr.length-position){
            return;
        }else{
            int max = 0;

            for(int i=position ; i < arr.length; i++){
                if(max<arr[i]){
                    max=arr[i];
                }


                list.add(i);
                maxProfit(arr, goal_k, cur_k+1, i, i+1, total+max, list, result_arr);
                list.removeLast();

            }


        }
    }

}
