package Backjoon;

/*
    모래시계
    https://www.acmicpc.net/problem/14571
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sandglass {

    static int nodeCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] list = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            list[a].add(b);
            list[b].add(a);
        }

        //solve
        System.out.println(solve(n, list));

    }

    private static int solve(int n, LinkedList<Integer>[] list) {

        int result = 0;

        for (int i = 0; i < n; i++) {
            //1st edge가 4 이상인 Node 탐색
            if (list[i].size() >= 4) {

                //2nd 이어진 Node의 edge가 2이상인 Node가 4개인가 확인
                int cnt = 0;
                LinkedList<Integer> tmp = new LinkedList<>();

                for (int j = 0; j < list[i].size(); j++) {
                    int t = list[i].get(j);
                    if (list[t].size() >= 2) {
                        cnt++;
                        tmp.add(t);
                    }
                }

                int [] arr = new int[tmp.size()];
                for (int j = 0; j < arr.length; j++) {
                    arr[j]=tmp.get(j);
                }

                if (cnt >= 4) {
                    //3rd 각각의 노드가 2개이상 연결되어 있는지 확인
                    //겹치는 edge 2개면 node 4개여야함, 반면 edge가 3개면 true
                    Arrays.sort(arr);
                    nodeCount = 0;

                    dfs(list, arr, new HashSet<Integer>(), 0, 0);

                    int combination = nodeCount*(nodeCount-1)/2;

                    result += combination;


                }
            }

        }

        return result;
    }

    private static void dfs(LinkedList<Integer>[] list, int[] arr, HashSet<Integer> set, int current, int cnt) {
        if(nodeCount<cnt)
            nodeCount=cnt;

        for(int i=current;i<arr.length;i++){
            int k = arr[i];

            for (int j = 0; j < list[k].size(); j++) {
                int now = list[k].get(j);
                if(now>k && !set.contains(now) && !set.contains(k)){
                    set.add(now);
                    set.add(k);
                    dfs(list, arr, set, i+1, cnt+1);
                    set.remove(now);
                    set.remove(k);
                }

            }

        }

    }

}
