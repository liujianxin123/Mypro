package bingfa.Future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) {

        try {
            // 创建任务 T2 的 FutureTask
            FutureTask<String> ft2 = new FutureTask<>(new T2Task());
            // 创建任务 T1 的 FutureTask
            FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));
            // 线程 T1 执行任务 ft1
            Thread T1 = new Thread(ft1);
            T1.start();
            // 线程 T2 执行任务 ft2
            Thread T2 = new Thread(ft2);
            T2.start();

            // 等待线程 T1 执行结果
            System.out.println(ft1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    // 一次执行结果：
//    T1: 洗水壶...
//    T2: 洗茶壶...
//    T1: 烧开水...
//    T2: 洗茶杯...
//    T2: 拿茶叶...
//    T1: 拿到茶叶: 龙井
//    T1: 泡茶...
//    上茶: 龙井

}
