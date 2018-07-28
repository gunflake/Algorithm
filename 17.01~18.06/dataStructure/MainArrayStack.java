package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 2..
 */
public class MainArrayStack {
    public static void main(String[] args){
        ArrayStack st = new ArrayStack(100);
        System.out.println(st.sIsEmpty());
        st.sPush(10);
        st.sPush(20);
        st.sPush(30);
        System.out.println(st);
        System.out.println(st.size());
        System.out.println(st.sIsEmpty());
        System.out.println(st.sPeak());
        System.out.println(st.sPop());
        System.out.println(st);
    }
}
