package threadpool;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    static class MyThread implements Runnable{

        private final int value;
        private final Semaphore semaphore;

        public MyThread(int value,Semaphore semaphore){
            this.value=value;
            this.semaphore=semaphore;
        }


        @Override
        public void run() {
            try {
                semaphore.acquire(); //获取permit
                System.out.printf("当前线程是%d, 还剩%d个资源，还有%d个线程在等待%n",value,semaphore.availablePermits(),semaphore.getQueueLength());
                //睡眠时间随机,打乱释放顺序
                Random random = new Random();
                Thread.sleep(random.nextInt(1000));
                System.out.printf("线程%d释放了资源%n", value);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                //释放permit
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread(i,semaphore)).start();
        }
    }


}
