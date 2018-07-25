package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 15..
 */
public class MainArrayQueue {
    public static void main(String[] args){
        ArrayQueue queue = new ArrayQueue(100);
        System.out.println(queue.qIsEmpty());
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.size());
        System.out.println(queue);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.size());
        System.out.println(queue.deQueue());
        System.out.println(queue);


    }
}
