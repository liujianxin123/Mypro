package bingfa.Future;

import java.util.concurrent.*;

public class FutureTest {

    public static void future(){
        try {
            // 创建 FutureTask
            FutureTask<Integer> futureTask = new FutureTask<>(()-> {
                int a = 1+3;
                return a;
            });
            // 创建线程池
            ExecutorService es = Executors.newCachedThreadPool();
            // 提交 FutureTask
            es.submit(futureTask);
            // 获取计算结果
            Integer result = futureTask.get();

            System.out.println("获取计算结果："+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        future();
    }

}
