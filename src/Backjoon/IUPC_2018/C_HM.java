package Backjoon.IUPC_2018;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C_HM {
    static LinkedList<Integer> [] list;
    static int [] weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new LinkedList[N];
        weight = new int[N];
        boolean [] check = new boolean[N];
        check[0]=true;

        for (int i = 0; i < N; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if(check[a]) {
                list[a].add(b);
                check[b] = true;
            }else{
                list[b].add(a);
                check[a]=true;
            }
        }

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int select = Integer.parseInt(st.nextToken());
            if(select == 1){
                int x = Integer.parseInt(st.nextToken())-1;

                //solve
                bw.write(""+allNodeXOR(x));
                if(i!=M-1)
                    bw.newLine();
            }else{
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken());

                //solve
                setNodeWeight(x, y);
            }
        }

        bw.flush();
        bw.close();



    }

    private static void setNodeWeight(int x, int y) {
        Queue<Integer> q = new LinkedList<>();

        weight[x] = weight[x] ^ y;
        for (int i = 0; i < list[x].size(); i++) {
            int cur = list[x].get(i);
            q.add(cur);
            weight[cur] = weight[cur]^y;
        }


        while(!q.isEmpty()){
            int tmp = q.poll();
            for (int i = 0; i < list[tmp].size(); i++) {
                int cur = list[tmp].get(i);
                q.add(cur);
                weight[cur]=weight[cur]^y;
            }
        }

    }

    private static int allNodeXOR(int x) {
        int result = weight[x];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < list[x].size(); i++) {
            q.add(list[x].get(i));
            result=result^weight[list[x].get(i)];
        }

        while(!q.isEmpty()){
            int tmp = q.poll();
            for (int i = 0; i < list[tmp].size(); i++) {
                q.add(list[tmp].get(i));
                result=result^weight[list[tmp].get(i)];
            }
        }
        return result;
    }

}
