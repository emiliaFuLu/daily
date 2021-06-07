package reentrantlock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.*;

/**
 * @author fl
 * @date 2021年04月12日 22:57
 * @Description
 */
public class SingleThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
//        pool.submit(()->{
//            try {
//                String s = pool.submit(() -> "QQ").get();
//                out.println(s);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        });

        String s = null;
        try {
            s = pool.submit(() -> {
                Thread.currentThread().setName("123123");
                return "QQ";
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        out.println(s);
    }
}
    