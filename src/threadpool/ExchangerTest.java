package threadpool;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

    public static void main(String[] args) throws InterruptedException {

        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            try {
                System.out.println("这里是线程A,得到了另一个线程的数据:" + exchanger.exchange("这是来自线程A的数据"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        System.out.println("这时候线程A是阻塞的,在等待线程B");
        Thread.sleep(100);

        new Thread(() -> {
            try {
                System.out.println("这里是线程B,得到了另一个线程的数据:" + exchanger.exchange("这是来自线程B的数据"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}

