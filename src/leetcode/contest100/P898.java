package leetcode.contest100;

import java.util.HashSet;

public class P898 {
    public int subarrayBitwiseORs(int[] A) {
        HashSet<Integer> set = new HashSet<>();



        for(int i=0;i<A.length;i++){
            int tmp = A[i];
            set.add(tmp);
            for(int j=i+1;j<A.length;j++){
                tmp = tmp | A[j];
                set.add(tmp);
            }
        }


        return set.size();
    }
}
