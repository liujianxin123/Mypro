package bingfa.Future;

import java.util.concurrent.*;

public class FutureTest {

    public void future(){
        try {
            // 创建 FutureTask
            FutureTask<Integer> futureTask = new FutureTask<>(()-> 1+2);
            // 创建线程池
            ExecutorService es = Executors.newCachedThreadPool();
            // 提交 FutureTask
            es.submit(futureTask);
            // 获取计算结果
            Integer result = futureTask.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }



}
