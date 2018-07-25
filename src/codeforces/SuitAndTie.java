/*
http://codeforces.com/contest/996/problem/D
 */

package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SuitAndTie {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        for(int i=0;i<2*n;i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        //solve
        System.out.println(solve(n, list));



    }

    private static int solve(int n, LinkedList<Integer> list) {

        int sum =0;

        while(!list.isEmpty())
            sum+=search(list);

        return sum;
    }

    private static int search( LinkedList<Integer> list) {
        int ldiff = -1;
        int count = 0;

        //--> search
        int pivot = list.get(0);
        for(int i=1;i<list.size();i++) {
            if(pivot==list.get(i)) {
                ldiff = i;
                break;
            }
        }

            count = ldiff-1;
            list.remove(ldiff);
            list.removeFirst();

        return count;
    }

}