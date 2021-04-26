package threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author fl
 * @date 2021年03月31日 21:10
 * @Description
 */
public class FutureTaskTest {
    public static void main(String[] args) {

        FutureTask<Integer> task = new FutureTask<>(() -> 1 + 2);
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(task);
        try {
            Integer integer = task.get();
            System.out.println(integer);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
    