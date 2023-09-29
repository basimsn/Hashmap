
public class GenericQueue<T> extends GenericList<T>{

    private Node<T> tail;
    GenericQueue(T value){
        Node<T>newNode = new Node<T>(value);
        setHead(newNode);
        tail = newNode;
    }
    GenericQueue(int code, T value){
        Node<T>newNode = new Node<T>(value);
        setHead(newNode);
        tail = newNode;
        newNode.code = code;
    }
    @Override
    public void add(T data) {
           Node<T> newNode = new Node<>(data);
           Node<T> temp = getHead();
           if(temp == null) {
               setHead(newNode);
           }
           else {
               tail.next = newNode;
               tail = newNode;
               setLength(getLength() + 1);
           }
    }
    public void add(T data, int code){
        Node<T> newNode = new Node<>(data);
        Node<T> temp = getHead();
        if(temp == null) {
            setHead(newNode);
        }
        else {
            tail.next = newNode;
            tail = newNode;
            setLength(getLength() + 1);
            tail.code = code;
        }
    }
    @Override
    public T delete() {
        Node<T> current = getHead();
        Node<T> previous = null;
        if (current == null) {
            return null;
        }
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            // Only one node in the list
            setHead(null);
            tail = null;
        } else {
            previous.next = null;
            tail = previous;
        }
        return current.data;
    }
    public void enqueue (T data){
        Node<T> newNode = new Node<>(data);
        if (tail == null){
            setHead(newNode);
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public T dequeue(){
        if(getHead() == null){
            return null;
        }
        Node<T> temp = getHead();
        setHead(getHead().next);

        if(getHead() == null){
            tail = null;
        }
        return temp.data;
    }
}
