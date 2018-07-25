package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 17..
 */
public class DequeLinked {
    private Node head, tail;
    private int size = 0;

    private class Node {
        private Object data;
        private Node prev, next;

        public Node(Object input) {
            data = input;
            prev = null;
            next = null;
        }

        public String toString() {
            return String.valueOf(data);
        }
    }

    public boolean dIsEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public void dAddFirst(Object input) {
        Node newNode = new Node(input);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void dAddLast(Object input) {
        Node newNode = new Node(input);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public String toString() {
        String str = "";
        Node temp = head;
        for (int i = 0; i < size; i++) {
            str += temp.data;
            if (i < size - 1)
                str += "->";
            temp = temp.next;
        }
        return str;
    }

    public Object dRemoveFIrst() {
        Object returnData;
        if (size == 0) {
            System.out.println("덱이 비어있음");
            return null;
        } else if (size == 1) {
            returnData = head.data;
            head = null;
            tail = null;
            size--;
            return returnData;
        } else {
            Node temp = head;
            returnData = temp.data;
            head = head.next;
            head.prev = null;
            temp = null;
            size--;
            return returnData;
        }
    }

    public Object dRemoveLast() {
        Object returnData;
        if (size == 0) {
            System.out.println("덱이 비어있음");
            return null;
        } else if (size == 1) {
            returnData = tail.data;
            head = null;
            tail = null;
            size--;
            return returnData;
        } else {
            Node temp = tail;
            returnData = temp.data;

            tail = tail.prev;
            tail.next = null;
            temp = null;
            size--;
            return returnData;
        }
    }

    public Object dGetFirst(){
        return head.data;
    }

    public Object dGetLast() {
        return tail.data;
    }

    }
