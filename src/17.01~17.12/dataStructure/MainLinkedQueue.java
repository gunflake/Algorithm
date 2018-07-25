package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 15..
 * 큐 연결리스트 메인 함수
 */
public class MainLinkedQueue {
    public static void main(String[] args){
        LinkedQueue q = new LinkedQueue();
        System.out.println(q.qIsEmpty());
        System.out.println(q);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        System.out.println(q);
        System.out.println(q.qIsEmpty());
        System.out.println(q.size());
        System.out.println("dequeue = "+q.deQueue());
        System.out.println(q);
        System.out.println("dequeue = "+q.deQueue());
        System.out.println(q);
        System.out.println("dequeue = "+q.deQueue());
        q.enQueue(11);
        q.enQueue(22);
        q.enQueue(33);
        System.out.println(q);
    }
}
