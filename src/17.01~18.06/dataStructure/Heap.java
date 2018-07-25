package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 17..
 */
public class Heap {
    private Object data[];
    private int size;

    private class HeapElem{
        private int
    }

    public Heap(int length) {
        data = new Object[length];
        size = 0;
    }

    public boolean hIsEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public int getParentIDX(int idx) {
        return idx / 2;
    }

    public int getLChildIDX(int idx) {
        return idx * 2;
    }

    public int getRChildIDX(int idx)_ {
        return idx * 2 + 1;
    }

    public void hInsert(Object data, int pr){
        int idx = size+1;

    }

    public int getHiPriChildIDX(int idx){

    }

}
