package threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import static java.lang.System.*;

/**
 * @author fulu
 */
public class FibonacciTest {


    static class Fibonacci extends RecursiveTask<Integer> {
        int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            } else {
                Fibonacci fibonacci1 = new Fibonacci(n - 1);
                fibonacci1.fork();

                Fibonacci fibonacci2 = new Fibonacci(n - 2);
                fibonacci2.fork();

                return fibonacci1.join() + fibonacci2.join();
            }
        }
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        out.println("CPU核数:" + Runtime.getRuntime().availableProcessors());
        long start = currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci(40);
        ForkJoinTask<Integer> future = forkJoinPool.submit(fibonacci);
        out.println(future.get());
        long end = currentTimeMillis();
        out.printf("耗时: %d millis", end - start);
    }

}




