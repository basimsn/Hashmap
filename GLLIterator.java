import java.util.Iterator;

public class GLLIterator<T> implements Iterator<T> {

    private GenericList<T> list;
    private GenericList.Node<T> current;

    public GLLIterator(GenericList<T> list) {
        this.list = list;
        this.current = list.getHead();
    }

    @Override
    public boolean hasNext() {
        if(current == null){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public T next() {
        T value = current.data;
        current = current.next;
        return value;
    }
}