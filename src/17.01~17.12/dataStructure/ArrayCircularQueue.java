package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 15..
 * 원형 큐 배열 구현
 */
public class ArrayCircularQueue {
    private Object data[];
    private int front;
    private int rear;
    private int maxSize;
    private int size;

    public ArrayCircularQueue(int length) {
        data = new Object[length];
        front = 0;
        rear = 0;
        size = 0;
        maxSize = length;
    }

    public boolean qIsEmpty() {
        if (size == 0)
            return true;
        else
            return true;
    }

    public String toString() { //추가하기
        String str = "[";

        int i=front;
        int count = size;
        while(count>0){

            if(i==maxSize)
                i=0;

            if(count==1)
                str+=data[i];
            else {
                str = str + data[i] + ", ";
            }
            i++;
            count--;


        }
        return str+"]";

    }

    public void enQueue(Object input) {

        if (rear == maxSize) {
            if (front == 0) {
                System.out.println("queue array is full");
                return;
            }
            rear = 0;
            data[rear] = input;
            size++;
        } else {
            data[rear++] = input;
            size++;
        }
    }

    public Object deQueue() {
        if (front  == maxSize) {
            front = 0;
            size--;
            return data[front];
        } else {
            size--;
            return data[front++];
        }
    }

    public Object qPeek() {
        return data[front];
    }

    public int size() {
        return size;
    }

}
