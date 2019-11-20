package bingfa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

public class FutureTaskTest {


    public static void main(String[] args) {
        // 创建 FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(()-> 1+2);
        // 创建线程池
        ExecutorService es = Executors.newCachedThreadPool();
        // 提交 FutureTask
        es.submit(futureTask);
        // 获取计算结果
        try {
            Integer result = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        FutureTaskTest futureTaskTest = new FutureTaskTest();
        futureTaskTest.convertTest();

    }

    public void convertTest() {
        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collected);

    }
}
