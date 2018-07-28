package leetcode;

import java.util.*;

public class P855 {
    public static void main(String[] args) {
        ExamRoom r = new ExamRoom(10);
        System.out.println(r.seat());
        System.out.println(r.seat());
        System.out.println(r.seat());
        System.out.println(r.seat());
        r.leave(4);
        System.out.println(r.seat());

    }

}

class ExamRoom {

    private int size;
    private TreeSet<Integer> set;
    private int N;

    public ExamRoom(int N) {
        set = new TreeSet<>();
        size = 0;
        this.N = N;
    }

    public int seat() {
        if (size == 0) {
            set.add(0);
            size++;
            return 0;
        } else if (size == 1) {
            Iterator<Integer> it = set.iterator();
            int tmp = it.next();
            size++;
            if (N - tmp - 1 > tmp) {
                set.add(N - 1);
                return N - 1;
            } else {
                set.add(0);
                return 0;
            }
        } else {
            Iterator<Integer> it = set.descendingIterator();
            int end = it.next();
            it = set.iterator();
            int start = it.next();
            int length = 0;
            int before = start;
            int savePosition = 0;
            while (it.hasNext()) {
                int tmp = it.next();
                if ((tmp - before) / 2 > length) {
                    length = (tmp - before) / 2;
                    savePosition = (tmp + before) / 2;
                }
                before = tmp;
            }

            if(start>= length && start>=N-1-end){
                set.add(0);
                size++;
                return 0;
            }
            if(N-1-end >length && N-1-end>start){
                set.add(N-1);
                size++;
                return N-1;
            }
            set.add(savePosition);
            size++;
            return savePosition;

        }
    }

    public void leave(int p) {
        set.remove(p);
        size--;
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
