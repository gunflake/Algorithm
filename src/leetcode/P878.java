package leetcode;

import java.util.LinkedList;

public class P878 {

    public int nthMagicalNumber(int N, int A, int B) {

        LinkedList<Integer> list = new LinkedList<>();

        int aSum = 0;
        int bSum = 0;

        if (A > B) {
            list.add(B);
            bSum = B;
        } else {
            list.add(A);
            aSum = A;
        }

        while (aSum != bSum) {
            if (aSum + A < bSum + B) {
                aSum += A;
                list.add(aSum);
            } else {
                bSum += B;
                list.add(bSum);
            }
        }

        list.removeLast();

        long lcd = aSum;
        long div = N / list.size();
        int mod = N % list.size();


        long r = 0;
        r = (lcd * div) % 1000000007;

        if (mod != 0) {
            r += list.get(mod - 1);
            r %= 1000000007;
        }

        return (int) r;
    }

    public static void main(String[] args) {
        P878 p = new P878();
        System.out.println(p.nthMagicalNumber(1000000000, 39999, 40000));

    }
}
