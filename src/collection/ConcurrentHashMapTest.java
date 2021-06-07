package collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.System.*;

/**
 * @author: fl
 * @data: 2021-02-25 09:09
 * @description:
 **/
public class ConcurrentHashMapTest {

    @Test
    public void test() {
//        Set set = new HashSet();
//        Map map = new HashMap<>();
//        map.values().iterator();
//        out.println("asd");
        ThreadFactory threadFactory;
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> submit = exec.submit(() -> {
            int i = 1 / 0;
        });
        try {
            Object a = submit.get();
            out.println(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
