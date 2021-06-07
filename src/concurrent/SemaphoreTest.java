package concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author: fl
 * @date: 2021-06-07 9:05 上午
 * @description:
 **/
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
//        Semaphore semaphore = new Semaphore(5);
//        for (int i = 0; i < 1; i++) {
//            new Thread(new SemaphoreWorker(semaphore)).start();
//        }


        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
             new Thread(new SemaphoreWorker2(semaphore)).start();
        }
        System.out.println("GO");
        semaphore.release(5);
        System.out.println("wait for permits off");

        while (semaphore.availablePermits()!=0){
            Thread.sleep(100);
        }
        System.out.println("GO");
        semaphore.release(5);
    }

}

class SemaphoreWorker implements Runnable {

    private String name;
    private Semaphore semaphore;

    public SemaphoreWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            log("is wait for permit~");
            semaphore.acquire();
            log("acquired a permit");
            log("execute");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void log(String msg) {
        if (name == null) {
            name = Thread.currentThread().getName();
        }
        System.out.println(name + "   " + msg);
    }
}

class SemaphoreWorker2 implements Runnable {

    private Semaphore semaphore;

    public SemaphoreWorker2(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("execute");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}