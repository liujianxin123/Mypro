package bingfa;

public class Account {
    private int id;
    private int balance;
    // 转账
    void transfer(Account target, int amt){
        Account left = this;            //①
        Account right = target;         //②
        if (this.id > target.id) {      //③
            left = target;              //④
            right = this;               //⑤
        }                               //⑥
        // 锁定序号小的账户
        synchronized(left){             //7
            // 锁定序号大的账户
            synchronized(right){
                if (this.balance > amt){
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
//a转b,b转a的问题：两个线程同时进行转账操作，第一个线程操作a转b,
// 第二个线程操作b转a,假如a是账号的小的，第一个线程到达第七步，
// 锁定的是a,第二个线程到达第七步锁定的也是a,但是此时a已经被第一个线程给锁定，
// 第二个线程如果想拿到a锁，就必须等到第一个线程
//释放a锁，这样第一个线程和第二个线程就不会出现竞争死锁的问题了，
// 不知道我理解的对不对，请同学们和老师指导