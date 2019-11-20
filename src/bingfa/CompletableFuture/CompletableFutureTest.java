package bingfa.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class CompletableFutureTest {
    public void cf(){
        CompletableFuture<String> f0 =
                CompletableFuture.supplyAsync(
                        () -> "Hello World", Executors.newSingleThreadExecutor())      //①
                        .thenApply(s -> s + " QQ")  //②
                        .thenApply(String::toUpperCase)
                        .exceptionally(new Function<Throwable, String>() {
                            @Override
                            public String apply(Throwable throwable) {
                                return null;
                            }
                        });//③

            System.out.println(f0.join());
        // 输出结果
        //HELLO WORLD QQ

    }

    /**
     * 烧水泡茶理论CompletableFuture实现
     */
    public void paocha(){


        // 任务 1：洗水壶 -> 烧开水
        CompletableFuture<Void> f1 =
                CompletableFuture.runAsync(()->{
                    try {
                        System.out.println("T1: 洗水壶...");
                        Thread.sleep(100);
                        System.out.println("T1: 烧开水...");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                });
        // 任务 2：洗茶壶 -> 洗茶杯 -> 拿茶叶
        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(()->{
                    System.out.println("T2: 洗茶壶...");

                    System.out.println("T2: 洗茶杯...");

                    System.out.println("T2: 拿茶叶...");
                    return " 龙井 ";
                });
        // 任务 3：任务 1 和任务 2 完成后执行：泡茶
        CompletableFuture<String> f3 = f1.thenCombine(f2,(r1,r2)->{
            System.out.println("T1: 拿到茶叶:");
            System.out.println("T1: 泡茶。。。:");
            return r2;
        });

        System.out.println(f3.join());



    }
}
