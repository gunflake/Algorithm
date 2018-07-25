package codeforces;

/*
    http://codeforces.com/contest/1000/problem/C
 */

import java.io.*;
import java.util.*;

public class CoveredPointsCount {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Long, Long> map = new TreeMap<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            long k = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            map.put(k, v);
        }

        //solve
        long [] result = solve(n, map);

        for (int i = 1; i <= n; i++) {
            bw.write(result[i]+" ");
        }
        bw.flush();
        bw.close();
        


    }

    private static long[] solve(int n, TreeMap<Long, Long> map) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        Iterator<Map.Entry<Long, Long>> it = map.entrySet().iterator();

        long[] result = new long[n + 1];

        Map.Entry mentry = it.next();
        long before = (long) mentry.getKey();
        pq.add((Long) mentry.getValue());

        while (it.hasNext()) {
            mentry = it.next();
            long start = (long) mentry.getKey();
            long end = (long) mentry.getValue();

            if (start <= pq.peek()) {
                result[pq.size()] += (start - before);
                before = start;
                pq.add(end);
            } else { //수정

                while (pq.size()>0 && start > pq.peek()) {

                    result[pq.size()] += pq.peek() - before + 1;
                    before = pq.peek()+1;

                    long t = pq.poll();
                    while (pq.size()>0 && t == pq.peek()){
                        pq.poll();
                    }

                }


                before=start;
                pq.add(end);


            }

        }

        while (pq.size() > 0) {

            result[pq.size()] += pq.peek()-before+1;
            before = pq.peek()+1;

            long t = pq.poll();
            while(pq.size()>0 && t == pq.peek()){
                pq.poll();
            }

        }

        return result;
    }


}


