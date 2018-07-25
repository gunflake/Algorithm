package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 2..
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(data);
        }
    }

    public void addFirst(Object input) {
        Node newNode = new Node(input);

        newNode.next = head;
        head = newNode;
        if (size == 0)
            tail = newNode;

        size++;
    }

    private Node getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void addLast(Object input) {
        if (size == 0) {
            addFirst(input);
        } else {
            Node newNode = new Node(input);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void add(int pos, Object input) {
        if (pos == 0)
            addFirst(input);
        else if (pos == size)
            addLast(input);
        else {
            Node newNode = new Node(input);
            newNode.next = getNode(pos);
            getNode(pos - 1).next = newNode;
            size++;
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            if (i == size - 1)
                str += getNode(i).data;
            else
                str = str + getNode(i).data + "->";
        }
        return str;
    }

    public Object get(int index) {
        return getNode(index).data;
    }

}
