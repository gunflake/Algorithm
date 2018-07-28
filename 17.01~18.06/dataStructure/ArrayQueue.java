package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 15..
 */
public class ArrayQueue {
    private Object data[];
    private int front = 0;
    private int rear = 0;

    public ArrayQueue(int length) {
        data = new Object[length];
        front = 0;
        rear = 0;
    }

    public boolean qIsEmpty() {
        if (front == rear)
            return true;
        else
            return false;
    }

    public String toString() { //추가하기
        String str = "[";
        for (int i = front; i < rear; i++) {
            if(i==rear-1)
                str+=data[i];
            else
                str=str+data[i]+", ";
        }
        return str + "]";
    }

    public void enQueue(Object input) {
        if(rear<data.length)
            data[rear++] = input;
        else
            System.out.println("큐 데이터 꽉참");
    }

    public Object deQueue() {
        return data[front++];
    }

    public Object qPeek(){
        return data[front];
    }
    public int size(){
        return rear-front;
    }


}
