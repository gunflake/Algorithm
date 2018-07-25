package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 17..
 */
public class DequeLinkedMain {
    public static void main(String[] args){
        DequeLinked deque = new DequeLinked();
        System.out.println(deque.dIsEmpty());
        deque.dAddFirst(2);
        deque.dAddFirst(1);
        deque.dAddLast(3);
        deque.dAddLast(4);
        System.out.println(deque);
        System.out.println(deque.dGetFirst());
        System.out.println(deque.dGetLast());
        System.out.println(deque);
        System.out.println(deque.dRemoveFIrst());
        System.out.println(deque.dRemoveLast());
        System.out.println(deque);
        System.out.println(deque.dRemoveFIrst());
        System.out.println(deque.dRemoveFIrst());
        System.out.println(deque.dRemoveFIrst());
        System.out.println(deque);
    }
}
