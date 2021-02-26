package reentrantlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: fl
 * @data: 2021-02-26 09:02
 * @description:
 **/
public class ReadWriteLockDemo {

    private static final ReentrantReadWriteLock REENTRANT_READ_WRITE_LOCK = new ReentrantReadWriteLock(true);
    private static final ReentrantReadWriteLock.ReadLock READ_LOCK = REENTRANT_READ_WRITE_LOCK.readLock();
    private static final ReentrantReadWriteLock.WriteLock WRITE_LOCK = REENTRANT_READ_WRITE_LOCK.writeLock();

    private static void read() {
        READ_LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取读锁,正在读取..");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            READ_LOCK.unlock();
        }
    }

    private static void write() {
        WRITE_LOCK.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取写锁,正在写入...");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            WRITE_LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> read()).start();
        new Thread(() -> read()).start();
        new Thread(() -> write()).start();
        new Thread(() -> write()).start();
    }

}
