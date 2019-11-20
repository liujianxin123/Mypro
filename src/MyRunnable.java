public class MyRunnable implements Runnable {
    private int i = 0;
    @Override
    public void run(){
        System.out.println("come in MyRunnable");
        for (i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
