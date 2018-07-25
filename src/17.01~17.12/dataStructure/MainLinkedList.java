package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 2..
 */
public class MainLinkedList {
    public static void main(String[] args){
        LinkedList link = new LinkedList();
        link.addFirst(10);
        link.addLast(20);
        link.add(1,1);
        link.add(0,0);
        link.add(4,4);
        link.addFirst("first");
        link.addLast("last");
        link.add(3,"add");
        System.out.println(link);

    }
}
