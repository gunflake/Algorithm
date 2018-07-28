package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 17..
 */
public class BTreeMain {
    public static void inOrderTraverse(BTreeNode main){
        if(main == null)
            return;
        inOrderTraverse(main.getLeftSubTree());
        inOrderTraverse(main.getRightSubTree());
        System.out.println(main.getData());
    }

    public static void main(String[] args){
        BTree bTree = new BTree();
        BTreeNode nd1 = new BTreeNode(1);
        BTreeNode nd2 = new BTreeNode(2);
        BTreeNode nd3 = new BTreeNode(3);
        BTreeNode nd4 = new BTreeNode(4);
        BTreeNode nd5 = new BTreeNode(5);
        BTreeNode nd6 = new BTreeNode(6);

        bTree.makeLeftSubTree(nd1, nd2);
        bTree.makeRightSubTree(nd1, nd3);
        bTree.makeLeftSubTree(nd2, nd4);
        bTree.makeRightSubTree(nd2, nd5);
        bTree.makeRightSubTree(nd3,nd6);

        inOrderTraverse(nd1);
    }
}
