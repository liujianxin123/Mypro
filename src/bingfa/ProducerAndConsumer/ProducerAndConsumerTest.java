package bingfa.ProducerAndConsumer;

import javafx.concurrent.Task;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerAndConsumerTest {

    //有界的阻滞队列
   BlockingDeque<Task> blockingDeque = new LinkedBlockingDeque<>(200);

    public void star(){
        //创建五个消费者线程去执行任务

        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.execute(()->{

                try {
                    while (true){
                        //获取批量任务
                        List<Task> ts = pollTasks();
                        //执行批量任务
                        execTaskst(ts);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            });
        }
    }

   public List<Task> pollTasks() throws Exception{

        List<Task> list = new LinkedList<Task>();
        //阻塞的获取一条任务
        Task t = blockingDeque.take();
        while (t != null){
            //非阻塞的获取一条任务
            t = blockingDeque.poll();
            list.add(t);
        }
        return list;
    }
    // 批量执行任务execTaskst
   public void execTaskst(List<Task> tasks){

   }
}
