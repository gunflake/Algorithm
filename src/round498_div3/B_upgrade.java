package round498_div3;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_upgrade {


    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] sort = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            sort[i] = tmp;
        }


        //solve
        int [] result_arr = solve(n, k, arr, sort);
        //output
        bw.write(total + "");
        bw.newLine();
        for (int i = 0; i < result_arr.length; i++) {
            bw.write(result_arr[i] + "");
            if (i != result_arr.length)
                bw.write(" ");
        }
        bw.flush();
        bw.close();


    }

    private static int[] solve(int n, int k, int[] arr, int[] sort) {
        LinkedList<Integer> list = new LinkedList<>();
        int [] result = new int[k];
        Arrays.sort(sort);
        HashSet<Integer> set = new HashSet<>();
        for (int i = arr.length - 1, j = 0; i >= 0 && j < k; i--, j++) {
            set.add(sort[i]);
            total+=sort[i];
        }

        int count = 0;
        int rest = k;
        for (int i = 0; i < arr.length && rest!= 0; i++) {
            if(set.contains(arr[i])){
                if(count==0){
                    rest--;
                    count++;
                    continue;
                }else{
                    list.add(i);
                    rest--;
                }
            }
        }

        if(list.size()==0){
            result[0]=n;
            return result;
        }

        result[0] = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result[i]= list.get(i)-list.get(i-1);
        }
        result[k-1] = n - list.getLast();


        return result;



    }


}
