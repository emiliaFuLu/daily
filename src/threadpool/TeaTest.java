package threadpool;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import static java.lang.System.*;

/**
 * @author fl
 * @date 2021年03月31日 21:17
 * @Description
 */
public class TeaTest {
    public static void main(String[] args) {
        FutureTask<String> f2 = new FutureTask<>(new T2Task());
        FutureTask<String> f1 = new FutureTask<>(new T1Task(f2));
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        t1.start();
        t2.start();

        try {
            out.println(f2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }

    static class T1Task implements Callable {
        FutureTask<String> ft2;

        T1Task(FutureTask<String> t2) {
            this.ft2 = t2;
        }

        @Override
        public String call() throws Exception {
            out.println("T1:洗水壶");
            TimeUnit.SECONDS.sleep(1);

            out.println("T1:烧水");
            TimeUnit.SECONDS.sleep(15);

            String s = ft2.get();
            out.println("T1:拿到茶叶" + s);

            out.println("T1:上茶");
            return "上茶" + s;
        }
    }

    static class T2Task implements Callable {
        @Override
        public String call() throws Exception {
            out.println("T2:洗茶壶");
            TimeUnit.SECONDS.sleep(1);

            out.println("T2:洗茶杯");
            TimeUnit.SECONDS.sleep(2);

            out.println("T2:拿茶叶");
            TimeUnit.SECONDS.sleep(1);

            return "龙井";
        }
    }


}
    