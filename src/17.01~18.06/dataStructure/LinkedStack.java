package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 2..
 */
public class LinkedStack {
    private Node top;
    private int size =0;

    private class Node{
        private Object data;
        private Node prev;
        public Node(Object input){
            data = input;
            prev = null;
        }
    }

    public void push(Object input){
        Node newNode = new Node(input);
        newNode.prev=top;
        top=newNode;
        size++;
    }

    public Object pop(){
        Node temp = top;
        Object returnData = temp.data;
        top=top.prev;
        temp=null;
        size--;
        return returnData;
    }

    public Object peek(){
        return top.data;
    }

    public boolean isEmpty(){
        if(size==0)
            return true;
        else
            return false;
    }



}
