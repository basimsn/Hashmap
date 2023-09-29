import java.util.Iterator;

public class ReverseGLLIterator<T> implements Iterator<T> {

    private GenericList<T> list;
    private GenericList.Node<T> current;

    public ReverseGLLIterator(GenericList<T> list) {
        this.list = list;
        this.current = list.getHead();
        while(this.current.next != null){
            this.current =this.current.next;
        }

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
        GenericList.Node<T> temp = list.getHead();

        T value = current.data;
        while(temp.next != current) {
            temp = temp.next;
        }
        value =current.data;
        return value;
    }
}