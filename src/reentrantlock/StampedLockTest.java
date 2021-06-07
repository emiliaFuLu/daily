package reentrantlock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * @author fl
 * @date 2021年03月29日 22:16
 * @Description
 */
class StampedLockTest {
    public static void main(String[] args) throws InterruptedException {
        final StampedLock lock
                = new StampedLock();
        Thread T1 = new Thread(() -> {
            // 获取写锁
            lock.writeLock();
            // 永远阻塞在此处，不释放写锁
            LockSupport.park();
        });
        T1.start();
// 保证 T1 获取写锁
        Thread.sleep(100);
        Thread T2 = new Thread(() ->
                // 阻塞在悲观读锁
                lock.readLock()
        );
        T2.start();
// 保证 T2 阻塞在读锁
        Thread.sleep(100);
// 中断线程 T2
// 会导致线程 T2 所在 CPU 飙升
        T2.interrupt();
        T2.join();
    }

    private int x, y;
    final StampedLock sl =
            new StampedLock();

    // 计算到原点的距离
    double distanceFromOrigin() {
        // 乐观读
        long stamp =
                sl.tryOptimisticRead();
        // 读入局部变量，
        // 读的过程数据可能被修改
        int curX = x, curY = y;
        // 判断执行读操作期间，
        // 是否存在写操作，如果存在，
        // 则 sl.validate 返回 false
        if (!sl.validate(stamp)) {
            // 升级为悲观读锁
            stamp = sl.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                // 释放悲观读锁
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(
                curX * curX + curY * curY);
    }
}