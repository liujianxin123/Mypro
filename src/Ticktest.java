import java.util.concurrent.CountDownLatch;

public class Ticktest {
    public static void main(String[] args){

    //实例化站台对象，并为每一个站台取名字
        Station station1=new Station("窗口1");
        Station station2=new Station("窗口2");
        Station station3=new Station("窗口3");
//        station2.setPriority(Thread.MAX_PRIORITY);
//        station1.setPriority(Thread.MIN_PRIORITY);
        // 让每一个站台对象各自开始工作
        station1.start();
        station2.start();

        station3.start();


//
//    final Thread t1 = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("t1---->"+i);
//            }
//
//        }
//    });
//    final Thread t2 = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            try{
//                t1.join();
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println("t2---->"+i);
//                }
//            }
//
//        }
//    });
//
//    t1.start();
//
//    t2.start();





    }
}
