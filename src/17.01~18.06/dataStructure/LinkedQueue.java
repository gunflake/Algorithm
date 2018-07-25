package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 15..
 * queue 연결리스트로 구현
 */
public class LinkedQueue {
    private Node front;
    private Node rear;
    private int size = 0;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object input) {
            data = input;
            next = null;
        }

        public String toString() {
            return String.valueOf(data);
        }
    }

    public String toString() {
        String str = "";
        Node temp = front;
        for (int i = 0; i < size; i++) {

            if (i == size - 1)
                str += temp.data;
            else
                str = str + temp.data + "->";

            temp = temp.next;
        }
        return str;
    }

    public void enQueue(Object input) {
        Node newNode = new Node(input);

        if(size==0){
            front = newNode;
            rear = newNode;
        }else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public Object deQueue() {

        Node temp = front;
        Object returnData = temp.data;
        temp = null;
        front = front.next;
        size--;
        return returnData;
    }

    public Object qPeek() {
        return front.data;
    }

    public boolean qIsEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public int size() {
        return size;
    }
}
