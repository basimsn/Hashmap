import java.util.ArrayList;
import java.util.Iterator;
public abstract class GenericList<T>{
    private Node<T> head;
    private int length;

    public ArrayList<T> dumpList(){
        ArrayList<T> list = new ArrayList<T>();
        Node<T> tempHead1 = head;
        while(tempHead1.next != null){
            list.add(tempHead1.data);
        }
        return list;
    }
    public void print(){
        Node<T> tempHead = head;
        if(tempHead == null){
            System.out.println("Empty List");
        }
        while(tempHead != null){
            System.out.println(head.data);
            tempHead = tempHead.next;
        }
    }
    public static class Node<T> {
        int code;
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
            next = null;
        }
    }
    public abstract void add(T data);
    public abstract T delete();
    void setLength(int length){
        this.length = length;
    }
    public int getLength(){
        return length;
    }
    public void setHead(Node<T> head1){
        this.head = head1;
    }
    public Node<T> getHead(){
        return head;
    }
    public T set(int index, T element){
        Node<T> tempH = getHead();
        T oldValue = null;
        if(index >9 || index<0){
            return null;
        }
        for(int i=0; i<=index; i++){
            tempH = tempH.next;
        }
        oldValue = tempH.data;
        tempH.data = element;
        return oldValue;
    }
    public Iterator<T> descendingIterator(){
        return new ReverseGLLIterator<T>(this);
    }
    public Iterator<T> iterator() {
        return new GLLIterator<T>(this);
    }
}