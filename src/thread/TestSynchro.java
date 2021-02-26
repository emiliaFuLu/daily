package thread;

/**
 * @author: fl
 * @data: 2020-10-27 14:06
 * @description:
 **/
public class TestSynchro implements Runnable{

    private volatile int count=100;

    public static void main(String[] args) {
        TestSynchro ts = new TestSynchro();
        Thread t1 = new Thread(ts,"线程1");
        Thread t2 = new Thread(ts,"线程2");
        Thread t3 = new Thread(ts,"线程3");

        t1.start();
        t2.start();
        t3.start();
    }

//    @Override
//    public void run() {
//        while (true) {
//            synchronized (this){
//                if (count > 0) {
//                    count--;
//                    System.out.println(Thread.currentThread().getName() + " count = " + count);
//                } else {
//                    break;
//                }
//            }
//        }
//    }
    @Override
    public void run() {
        while (true) {
                if (count > 0) {
                    count--;
                    System.out.println(Thread.currentThread().getName() + " count = " + count);
                } else {
                    break;
                }
            }
    }
}
