import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import java.util.ArrayList;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HMTest {
    static MyHashMap<String> sMap;
    static MyHashMap<Integer> iMap;

    @Test
    public void putTest(){
        sMap = new MyHashMap<String>("key", "value");
        sMap.put("1","1");
        assertEquals(2, sMap.size());
    }
    @Test
    public void replaceTest(){
        sMap = new MyHashMap<String>("key", "value");
        sMap.put("1","1");
        sMap.replace("1", "2");
        assertEquals("1", sMap.get("1"));
    }
    @Test
    public void getTest(){
        sMap = new MyHashMap<String>("key", "value");
        sMap.put("1","1");
        assertEquals("1", sMap.get("1"));
    }
    @Test
    public void containsTest(){
        sMap = new MyHashMap<String>("key", "value");
        sMap.put("1","1");
        assertEquals(true, sMap.contains("1"));
    }
    @Test
    public void sizeTest(){
        sMap = new MyHashMap<String>("key", "value");
        sMap.put("1", "1");
        sMap.put("2", "2");
        assertEquals(3, sMap.size());
    }

}
