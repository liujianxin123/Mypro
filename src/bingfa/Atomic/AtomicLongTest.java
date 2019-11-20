package bingfa.Atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest {

        AtomicLong count = new AtomicLong(0);
        void add10K() {
            int idx = 0;
            while(idx++ < 10000) {
                count.getAndIncrement();
            }

        }

    public static void main(String[] args) {
        AtomicLongTest t = new AtomicLongTest();
        CountDownLatch a = new CountDownLatch(2);
        Thread t1 = new Thread(()->{
            t.add10K();
        });
        Thread t2 = new Thread(()->{
            t.add10K();
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.count.toString());
    }
}
