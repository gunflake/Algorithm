package dataStructure;

/**
 * Created by NamHyukMin on 2017. 5. 1..
 */
public class ArrayStack {
    private Object data[];
    private int size;

    public ArrayStack(int length) {
        data = new Object[length];
        size = 0;
    }

    public boolean sIsEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            if (i == size - 1)
                str += data[i];
            else
                str = str + data[i] + ", ";
        }
        return str+"]";
    }

    public void sPush(Object input) {
        data[size++] = input;
    }

    public Object sPop(){
        return data[--size];
    }
    public Object sPeak(){
        return data[size-1];
    }
    public int size(){
        return size;
    }

}
