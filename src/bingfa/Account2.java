package bingfa;

public class Account2 {
    // actr 应该为单例
    private Allocator actr;
    private int balance;
    // 转账
    void transfer(Account2 target, int amt){
        // 一次性申请转出账户和转入账户，直到成功
        while(!actr.apply(this, target));
        try{
            // 锁定转出账户
            synchronized(this){
                // 锁定转入账户
                synchronized(target){
                    if (this.balance > amt){
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } finally {
            actr.free(this, target);
        }
    }
    public static void main(String[] args){
        final Account2 a = new Account2();
        final Account2 b = new Account2();
        try {
            Thread th1 = new Thread(()->{
                while (true)
                    a.transfer(b, 100);
            }, "T1");
            Thread th2 = new Thread(()->{
                while (true)
                    b.transfer(a, 100);
            }, "T2");

            th1.start();
            th2.start();
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
