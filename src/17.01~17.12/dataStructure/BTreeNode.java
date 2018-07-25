package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 17..
 */
public class BTreeNode {
    private Object data;
    private BTreeNode left, right;
    public BTreeNode(Object input){
        data=input;
    }
    public void setLeft(BTreeNode sub){
        left = sub;
    }
    public void setRight(BTreeNode sub){
        right = sub;
    }
    public BTreeNode getLeftSubTree(){
        return left;
    }
    public BTreeNode getRightSubTree(){
        return right;
    }
    public Object getData(){
        return data;
    }
}
