package thread;

/**
 * @author: fl
 * @data: 2021-02-27 16:32
 * @description:
 **/
public class Join {


    static class ThreadA implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("我是子线程，我先睡一秒");
                Thread.sleep(1000);
                System.out.println("我是子线程，我先睡完了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new ThreadA());
        threadA.start();
//        threadA.join();
        System.out.println("加了join");


        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

    }


}
