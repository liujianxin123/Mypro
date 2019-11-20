package bingfa.Semaphore;

import java.util.Queue;

/**
 * 信号量模型
 */
public class SemaphoreTest {
    // 计数器
    int count;
    // 等待队列
    Queue queue;
    // 初始化操作
    SemaphoreTest(int c){
        this.count=c;
    }
    //
    void down(){
        this.count--;
        if(this.count<0){
            // 将当前线程插入等待队列
            // 阻塞当前线程
        }
    }
    void up(){
        this.count++;
        if(this.count<=0) {
            // 移除等待队列中的某个线程 T
            // 唤醒线程 T
        }
    }
}

