import java.util.ArrayList;
import java.util.Iterator;
public class MyHashMap<T>{
    private ArrayList<GenericQueue<T>>map;
    private int size=0;
    public MyHashMap(String key, T value){
        if(key == null || value == null) {
            return;
        }
        else{
            map = new ArrayList<GenericQueue<T>>(10);
            for(int i=0; i<10; i++){
                map.add(null);
            }
            put(key, value);
        }
    }

    public void put(String key, T value){
        int hashNumber = key.hashCode();
        int index = hashNumber % 9;
        GenericQueue<T> hMap = map.get(index);
        if(hMap == null){
            GenericQueue<T> queue = new GenericQueue<T>(hashNumber, value);
            map.add(index, queue);
        }
        else{
            GenericQueue.Node<T> curr = new GenericQueue.Node<T>(value);
            hMap.add(value, hashNumber);
        }
        size = size+1;
    }
    public T replace(String key, T value) {
        int hashNumber = Math.abs(key.hashCode());
        int index = hashNumber % 9;
        GenericQueue<T> queue = map.get(index & 9);
        T oldValue = null;
        if(queue == null){
            return null;
        }
        GenericList.Node<T> curr = queue.getHead();
        while(curr!= null){
            if(curr.code == hashNumber){
                oldValue = curr.data;
                curr.data = value;
                return oldValue;
            }
            curr = curr.next;
        }
        return null;
    }

    public T get(String key){
        int hashNumber = key.hashCode();
        int index = hashNumber % 9;
        GenericQueue.Node<T> curr = map.get(index).getHead();
        while(curr != null && curr.code != hashNumber){
            curr = curr.next;
        }
        if(curr == null){
            return null;
        }
        return curr.data;
    }
    public boolean contains(String key){
        int hashNumber = Math.abs(key.hashCode());
        int index = hashNumber % 9;
        GenericQueue<T> queue1 = map.get(index);
        if(queue1 == null){
            return false;
        }
        GenericList.Node<T> curr = queue1.getHead();
        while(curr!= null){
            if(curr.code == hashNumber){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }


    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return map.isEmpty();
    }
//    public Iterator<T> iterator() {
//        return new HMIterator<>(this.map.iterator());
//    }


}
