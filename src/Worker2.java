import java.util.concurrent.CountDownLatch;

public class Worker2 extends Thread{

    private String name;
    private CountDownLatch countDownLatch;

    @Override
    public void run(){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            for (int i = 0; i < 10; i++) {
                System.out.println("t2---->"+i);
            }
        }
    }
    public Worker2(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;

    }
}
