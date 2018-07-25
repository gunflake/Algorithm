package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 15..
 * 원형 큐 메인
 */
public class MainArrayCircularQueue {
    public static void main(String[] args){
        ArrayCircularQueue q = new ArrayCircularQueue(3);
        System.out.println(q);
        System.out.println(q.qIsEmpty());
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        System.out.println(q);
        System.out.println("dequeue ="+q.deQueue());
        System.out.println(q);
        q.enQueue(1);
        System.out.println(q);
        System.out.println(q.size());
    }
}
