package ProjectFour;

public class DoubleLinkedList<E>  {
    protected NodeD<E> top;      // The first NodeD<E> in the list

    // This instance variable is not required, however if you
    // find it useful, then you are welcome to use it
    protected NodeD<E> cursor;  // The current NodeD<E> in the list

    private int length;

    public DoubleLinkedList() {
        top = null;
        cursor = null;
    }

    public E get(int position) {
        cursor = top;
        for (int i = 0; i < position; i++)
            cursor = cursor.getNext();
        return cursor.getData();

    }

    public String toString() {
        String retVal = "";
        NodeD<E> cur = top;
        while (cur != null) {
            retVal += cur.getData();
            cur = cur.getNext();
        }

        return retVal;
    }


    public void addNode(E data){
        //
        NodeD add = new NodeD();
        add.setData(data);

        //
        if(top == null) {
            top = add;
            length++;
        }
        else {
            cursor = top;
            for(int i = 0; i < getLen() - 1; i++){
                cursor = cursor.getNext();
            }
            add.setPrev(cursor);
            add.setNext(null);
            cursor.setNext(add);
            length++;
        }
    }
    public int getLen() {
        int count = 0;
        NodeD<E> temp = top;
        while(temp != null){
            count ++;
            temp = temp.getNext();
        }
        return count;
    }


}