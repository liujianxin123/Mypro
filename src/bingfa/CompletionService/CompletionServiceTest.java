package bingfa.CompletionService;

import com.sun.imageio.plugins.common.I18N;

import java.util.List;
import java.util.concurrent.*;

/**
 * 用ExecutorCompletionService实现异步查询
 */
public class CompletionServiceTest {
    public void tet(){
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // 创建 CompletionService
        CompletionService<List> cs = new ExecutorCompletionService<>(executor);
        // 异步向电商 S1 询价
        cs.submit(()->getPriceByS1());
        // 异步向电商 S2 询价
        cs.submit(()->getPriceByS2());
        // 异步向电商 S3 询价
        cs.submit(()->getPriceByS3());
        // 将询价结果异步保存到数据库
        for (int i=0; i<3; i++) {
           List r = null;
            try {
                r = cs.take().get();
                executor.execute(()->save());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

    }

    public static void save(){
        //此处是数据库保存额的逻辑
    }
    public List getPriceByS1(){
        //此处是数据库保存额的逻辑
        return null;
    }
    public List getPriceByS2(){
        //此处是数据库保存额的逻辑
        return null;
    }
    public List getPriceByS3(){
        //此处是数据库保存额的逻辑
        return null;
    }
}
