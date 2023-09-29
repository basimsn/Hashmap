import org.junit.Test;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GQTest {
    @Test
    public void GQConstructorTest(){
        GenericQueue<Integer> list = new GenericQueue<>(1);
        Iterator<Integer> iterator = list.iterator();
        assertEquals(iterator.next(), 1);
        GenericList<Integer> list1 = new GenericQueue<>(1);
        Iterator<Integer> iterator1 = list1.iterator();
        assertEquals(iterator1.next(), 1);
    }
    @Test
    public void addDataTest(){
        GenericQueue<Integer> list = new GenericQueue<>(1);
        list.add(11);
        list.add(12);
        Iterator<Integer> iterator = list.iterator();
        assertEquals(iterator.next(), 1);
        assertEquals(iterator.next(), 11);
    }
    @Test
    public void addDataCodeTest(){
        GenericQueue<Integer> list = new GenericQueue<>(5, 10);
        list.add(11, 1);
        list.add(12,0);
        Iterator<Integer> iterator = list.iterator();
        assertEquals(iterator.next(), 10);
        assertEquals(iterator.next(), 11);

    }

    @Test
    public void iteratorTest(){
        GenericQueue<Integer> list = new GenericQueue<>(3);
        list.add(9);
        list.add(10);
        list.add(11);
        Iterator<Integer> iterator = list.iterator();
        assertEquals(iterator.hasNext(), true);
        assertEquals(iterator.next(), 3);
    }
    @Test
    public void deleteTest(){
        GenericQueue<Integer> list = new GenericQueue<>(1);
        list.add(11);
        list.add(12);
        assertEquals(list.delete(), 12);
        assertEquals(list.delete(), 11);
        assertEquals(list.delete(), 1);
        assertEquals(list.delete(), null);
    }
    @Test
    public void enqueueAndDequeueTest(){
        GenericQueue<Integer> queue = new GenericQueue<>(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.dequeue(), 2);
        assertEquals(queue.dequeue(), 3);
        assertEquals(queue.dequeue(), 4);
        assertEquals(queue.dequeue(), null);

    }
    @Test
    public void descendingIterator(){
        GenericQueue<Integer> list = new GenericQueue<>(3);
        list.add(9);
        list.add(10);
        list.add(11);
        Iterator<Integer> iterator = list.descendingIterator();
        assertEquals(iterator.hasNext(), true);
        assertEquals(iterator.next(), 11);
    }
}
