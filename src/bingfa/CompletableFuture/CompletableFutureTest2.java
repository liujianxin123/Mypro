package bingfa.CompletableFuture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureTest2 {

    public static void main(String[] args) {
        CompletableFutureTest2.thenAccept();
    }


    /**
     * thenAccept使用案例
     *
     * thenAccept没有返回值，thenApply又返回值
     */
    public static void thenAccept(){
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(()->{
            return 1+2;
        }, Executors.newSingleThreadExecutor());

        CompletableFuture<Void> b = CompletableFuture.runAsync(()->{
            System.out.println("执行b...");
        });
        CompletableFuture<String> c = a.thenApply(cb->{
            System.out.println("输出a的执行结果"+cb);
            return "c执行完";
        });

        CompletableFuture<Void> d = a.thenAccept(dd->{
            System.out.println("输出a的执行结果dd");
        });
        try {

            System.out.println("输出c的执行结果"+c.get());
            System.out.println("输出c的执行结果"+d.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {

        }
    }

    /**
     * 功能:当运行出现异常时,调用该方法可进行一些补偿操作,如设置默认值.
     *
     * 场景:异步执行任务A获取结果,如果任务A执行过程中抛出异常,则使用默认值100返回
     */
    public static void exceptionally(){
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "异步执行结果:" + (100 /3))
//                .thenApply((s)->{
//                    System.out.println("获取异步执行的结果执行任务B"+s+4);
//                    return "";
//                })
                .exceptionally(e -> {
                    System.out.println(e.getMessage()); //java.lang.ArithmeticException: / by zero
                    return "出错后给默认值给A默认值 100";
                });
        CompletableFuture<String> futureB = CompletableFuture.
                supplyAsync(() -> "异步执行结果:" + 50/2)
                .thenApply(s -> "获取异步的执行结果，futureB result:" + s)
                .exceptionally(e -> "futureB result: 100");
        System.out.println(futureA.join());//futureA result: 100
        System.out.println(futureB.join());//futureB result:执行结果:50
    }

    /**
     *　　功能:当CompletableFuture的计算结果完成，或者抛出异常的时候，都可以进入whenComplete方法执行,举个栗子
     */
    public static void whenComplete(){
        CompletableFuture<String> futureA = CompletableFuture.
                supplyAsync(() -> "执行结果:" + (100 / 0))
                .thenApply(s -> "apply result:" + s)
                .whenComplete((s, e) -> {
                    if (s != null) {
                        System.out.println("s不等于null:"+s);//未执行
                    }
                    if (e != null) {
                        System.out.println("e等于null的结果："+e);//e是异常消息
                    } else {
                        System.out.println(e.getMessage());//java.lang.ArithmeticException: / by zero
                    }
                })
                .exceptionally(e -> {
                    System.out.println("ex"+e.getMessage()); //ex:java.lang.ArithmeticException: / by zero
                    return "futureA result: 100";
                });
        System.out.println(futureA.join());//futureA result: 100
    }

    /**
     * 需要根据商品id查询商品的当前价格,分两步,查询商品的原始价格和折扣,这两个查询相互独立,当都查出来的时候用原始价格乘折扣,算出当前价格. 使用方法:thenCombine(..)
     */
    public static void thenCombine(){
        CompletableFuture<Double> future1 = CompletableFuture.supplyAsync(()->100d);
        CompletableFuture<Double> future2 = CompletableFuture.supplyAsync(()->0.8);
        CompletableFuture<Double> future3 = future1.thenCombine(future2,(f1_result,f2_result)->{
            return f1_result*f2_result;
        });

        System.out.println(future3.join());

    }

    public static void ttt(){
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "任务A");
        CompletableFuture<Integer> futureB = CompletableFuture.supplyAsync(() ->{
            Map<String,Integer> map = new HashMap<String,Integer>();
            map.put("test",12);
            return map;
        }).thenApply(b ->{
            System.out.println("执行任务C.");
            Map<String,Integer> map = (Map)b;
            Integer a = map.get("test");
            System.out.println("参数:" + a/0);//参数:任务B
            return a;
        }).exceptionally(e ->{
            System.out.println("ex"+e.getMessage()); //ex:java.lang.ArithmeticException: / by zero
            return 100;
        });
//        CompletableFuture<Integer> futureC = futureB.thenApply(b -> {
//            System.out.println("执行任务C.");
//            Map<String,Integer> map = (Map)b;
//            Integer a = map.get("test");
//            System.out.println("参数:" + a/0);//参数:任务B
//            return a;
//        }).exceptionally(e -> {
//            System.out.println("ex"+e.getMessage()); //ex:java.lang.ArithmeticException: / by zero
//            return 100;
//        });
//        System.out.println(futureA.join());
//        System.out.println(futureB.join());
       // System.out.println(futureC.join());



    }


    /**
     *
     * @param jsonData
     * @return
     */
//    @WebLog
//    @PostMapping(value = "getResultBack")
//    public String getResultBack(String jsonData){
//
//        JSONObject jsonObject = JSONObject.parseObject(jsonData);
//        String phone = jsonObject.getString("phone");
//        String test = redisUtils.get(phone);
//
//        System.out.println(test);
//
//        JSONObject j = JSONObject.parseObject(test);
//
//
//        String result = null;
//        boolean flag = true;
//
//        ArrayBlockingQueue<Runnable> blockingDeque = new ArrayBlockingQueue<>(4);
//        //创建线程池，避免重复创建线程
//        ExecutorService es = new ThreadPoolExecutor(2,4,1000,TimeUnit.MILLISECONDS,blockingDeque);
//        while (flag){
//
//            try {
//                // 创建FutureTask
//                FutureTask<String> futureTask= new FutureTask<String>(()->{
//
//                    return redisUtils.get(phone);
//                });
//
//                es.submit(futureTask);
//
//                System.out.println(Thread.currentThread().getName());
//                // 获取计算结果
//                result = futureTask.get();
//
//                if(result != null){
//                    flag = false;
////                    redisUtils.del(phone);
//                    es.shutdown();
//                }else{
//                    Thread.currentThread().sleep(6*10000);//每隔60秒调一次
//                }
//
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//
//        return respJson(CodeEnum.SUCC, JSONObject.parseObject(result));
//    }

}
