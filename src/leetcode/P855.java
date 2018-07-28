package leetcode;

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
    static boolean[] check;
    static int size;
    static int N;

    public ExamRoom(int N) {
        check = new boolean[N];
        size = 0;
        this.N = N;
    }

    public int seat() {
        if(size==0){ // empty class
            check[0]=true;
            return 0;
        }else{

            int count = 0;
            int max = 0;
            int before = -1;

            for (int i = 0; i < N; i++) {
                if(check[i]){ // true

                    if(count%2==1){

                    }else{

                    }


                }else{ //false
                    count++;
                }
            }



        }


    }

    public void leave(int p) {
        size--;
        check[p] = false;
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
