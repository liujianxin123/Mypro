package bingfa.ThreadLocal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeDateFormat {

        // 定义 ThreadLocal 变量
        static final ThreadLocal<DateFormat>
                tl=ThreadLocal.withInitial(
                ()-> new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss"));

        static DateFormat get(){
            return tl.get();
        }
    // 不同线程执行下面代码
    // 返回的 df 是不同的
    DateFormat df = SafeDateFormat.get();

        public void aa(){
            Lock lock = new ReentrantLock();
            // 条件变量：队列不满
            final Condition notFull = lock.newCondition();
            try {
                notFull.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}

