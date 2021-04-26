package threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author fl
 * @date 2021年03月31日 21:39
 * @Description
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws Exception{
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(()->{
            try {
                System.out.println("T1:洗水壶");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("T1:烧水");
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("T2:洗茶壶...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("T2:洗茶杯");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("T2:拿茶叶");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "龙井";
        });

        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("T3:拿到茶叶:" + tf);
            System.out.println("T3:泡茶");
            return "上茶:" + tf;
        });

        System.out.println(f3.join());

    }

}
    