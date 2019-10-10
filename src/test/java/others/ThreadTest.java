package others;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class ThreadTest {

    @Test
    public void test(){

        Map<Integer,Integer> map = new Hashtable<>();

        Thread thread = new Thread(()->{
            for (int i = 0;i<10;i++){
                map.put(i,i);
                System.out.println(Thread.currentThread().getName()+"=>>put"+i);
                try{
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("==============1");
        try{
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("==============2");
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(Thread.currentThread().getName()+"=<<get"+iterator.next());
        }

    }
}
