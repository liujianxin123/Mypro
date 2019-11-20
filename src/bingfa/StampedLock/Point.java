package bingfa.StampedLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

class Point {
    private int x, y;
    final StampedLock sl = new StampedLock();
    // 计算到原点的距离
    int distanceFromOrigin() {
        // 乐观读
        long stamp = sl.tryOptimisticRead();
        // 读入局部变量，
        // 读的过程数据可能被修改
        int curX = x, curY = y;
        // 判断执行读操作期间，
        // 是否存在写操作，如果存在，
        // 则 sl.validate 返回 false
        if (!sl.validate(stamp)){
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
        return (int) Math.sqrt(curX * curX + curY * curY);
    }

//    public void order(){
//        // 创建 2 个线程的线程池
//        Executor executor = Executors.newFixedThreadPool(2);
//        while(存在未对账订单){
//            // 计数器初始化为 2
//            CountDownLatch latch = new CountDownLatch(2);
//            // 查询未对账订单
//            executor.execute(()-> {
//                pos = getPOrders();
//                latch.countDown();
//            });
//            // 查询派送单
//            executor.execute(()-> {
//                dos = getDOrders();
//                latch.countDown();
//            });
//
//            // 等待两个查询操作结束
//            latch.await();
//
//            // 执行对账操作
//            diff = check(pos, dos);
//            // 差异写入差异库
//            save(diff);
//        }
//
//    }

}

