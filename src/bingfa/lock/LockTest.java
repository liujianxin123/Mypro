package bingfa.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private final Lock lock = new ReentrantLock();
    int value = 0;
    public void test() throws Exception{

        //获取锁
        lock.lockInterruptibly();//能够响应中断的锁
        try {
            value+=1;
        }finally {
            //释放锁
            lock.unlock();
        }

    }


    public int get() {
        // 获取锁
        lock.lock();         //②
        try {
            return value;
        } finally {
            // 保证锁能释放
            lock.unlock();
        }
    }
    public void addOne() {
        // 获取锁
        lock.lock();
        try {
            value = 1 + get(); //①
        } finally {
            // 保证锁能释放
            lock.unlock();
        }
    }
}
