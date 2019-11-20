import java.util.concurrent.CountDownLatch;

public class Testny {
    public static void main(String args[]){
//        A a = new A();
//        B b = new B();
//        C c = new C();
//        D d = new D();
//
//
//
//        System.out.println(a.get(b));
//        System.out.println(b.get(a));
//        System.out.println(b.get(c));
//        System.out.println(b.get(d));
    try{
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Worker worker0 = new Worker("worker0", (long) (Math.random()*2000+3000), countDownLatch);
        Worker worker1 = new Worker("worker1", (long) (Math.random()*2000+3000), countDownLatch);
        Worker worker2 = new Worker("worker2", (long) (Math.random()*2000+3000), countDownLatch);

        worker0.start();
//        worker1.start();
//        countDownLatch.await();
//
//        System.out.println("准备工作就绪");
//        worker2.start();
    }catch (Exception e){
        e.printStackTrace();
    }
    Thread th = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        }
    });

        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        Thread1 mTh1=new Thread1("A");
        Thread1 mTh2=new Thread1("B");
        mTh1.start();
        try{
            mTh1.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        mTh2.start();
        try{
            mTh2.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");


    }
}
