package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 17..
 */
public class BTree {
    public void makeLeftSubTree(BTreeNode main, BTreeNode sub) {
        if (main.getLeftSubTree() != null)
            main.setLeft(null);
        main.setLeft(sub);
    }

    public void makeRightSubTree(BTreeNode main, BTreeNode sub) {
        if (main.getRightSubTree() != null)
            main.setRight(null);
        main.setRight(sub);
    }

    public Object getLeftData(BTreeNode main) {
        return main.getLeftSubTree().getData();

    }

    public Object getRightData(BTreeNode main) {
        return main.getRightSubTree().getData();

    }

}
