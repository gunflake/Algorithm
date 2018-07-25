package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 2..
 */
public class MainLinkedStack {
    public static void main(String[] args){
        LinkedStack st = new LinkedStack();
        System.out.println(st.isEmpty());
        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st.peek());
        System.out.println(st.isEmpty());
        System.out.println(st.pop());
        st.pop();
        st.pop();
        System.out.println(st.isEmpty());
    }
}
