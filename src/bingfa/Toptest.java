package bingfa;

public class Toptest {
    public static void main(String[] args) {
//        Thread t1 = new Thread(()->{
//            int i = 0;
//            while (true){
//                System.out.println(i++);
//            }
//        });
//        t1.start();

        Thread ta = new Thread(()->{
            synchronized (A.A){
                System.out.println("我要开始执行任务A。。。。" + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B.B) {
                }
                System.out.println("我在执行任务结束了A。。。。" + Thread.currentThread().getName() + ":" + B.B.hashCode() + ":"
                        + A.A.hashCode());
            }
        },"线程1");

        Thread tb = new Thread(()->{
            synchronized (B.B){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A.A) {
                }
                System.out.println("我在执行任务结束了B。。。。" + Thread.currentThread().getName() + ":" + B.B + ":" + A.A);
            }
        },"线程2");

        ta.start();
        tb.start();
    }
    public static class A {
        static Integer A = new Integer(1);
    }
    public static class B {
        static Integer B = new Integer(1);
    }

    private Integer num = 0;
    public Integer cas(Integer exp,Integer newNum){

        int count = num;
        if(exp == num){
            num = newNum;
        }
        return newNum;
    }
}
