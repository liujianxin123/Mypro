import java.util.concurrent.CountDownLatch;

public class Worker extends Thread{

    private String name;
    private CountDownLatch countDownLatch;
    private long time;

    public Worker(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;

    }
    public Worker(String name, long time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run(){

        try {
            System.out.println(name+"开始工作");
            Thread.sleep(time);
            System.out.println(name+"第一阶段工作完成");

            countDownLatch.countDown();

            Thread.sleep(2000); //这里就姑且假设第二阶段工作都是要2秒完成
            System.out.println(name+"第二阶段工作完成");
            System.out.println(name+"工作完成，耗费时间="+(time+2000));

        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

}
