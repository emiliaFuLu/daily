package thread;


/**
 * @author: fl
 * @data: 2020-12-23 09:53
 * @description:
 **/
public class Threadtest_1 {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                testmethod();
            }
        },"1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                testmethod();
            }
        },"2");
        thread1.start();
        Thread.sleep(1000L);
        thread2.start();

        System.out.println(thread1.getName()+"----------"+thread1.getState());
        System.out.println(thread2.getName()+"----------"+thread2.getState());

    }

    public static synchronized void testmethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

