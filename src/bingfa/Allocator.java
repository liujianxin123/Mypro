package bingfa;

import java.util.ArrayList;
import java.util.List;

public class Allocator {
    private List<Object> als = new ArrayList<>();
    // 一次性申请所有资源
    synchronized boolean apply(Object from, Object to){
        if(als.contains(from) || als.contains(to)){
            return false;
        } else {
            als.add(from);
            als.add(to);
        }
        return true;
    }
    // 归还资源
    synchronized void free(Object from, Object to){
        als.remove(from);
        als.remove(to);
    }
}

//class Account {
//    // actr 应该为单例
//    private Allocator actr;
//    private int balance;
//    // 转账
//    void transfer(Account target, int amt){
//        // 一次性申请转出账户和转入账户，直到成功
//        while(!actr.apply(this, target));
//        try{
//            // 锁定转出账户
//            synchronized(this){
//                // 锁定转入账户
//                synchronized(target){
//                    if (this.balance > amt){
//                        this.balance -= amt;
//                        target.balance += amt;
//                    }
//                }
//            }
//        } finally {
//            actr.free(this, target);
//        }
//    }
//}

//a转b,b转a的问题：第一个线程执行a转b，第二个线程执行b转a，第一，第二个线程同时到达transfer方法进行转账
//的时候，actr是单例的，假如第一个线程先执行，进入apply的方法，第一次就会返回true,然后进入try的方法，
// 这里有一个疑问？第二个线程进入apply的方法的时候，als这个数组里面是null的还是已经有了a和b两个对象了
//代码有一个归还资源的操作，意思是，线程一不执行完，资源是不会归还的，也就是说线程二，到达apply的方法后
// 会返回true,那线程二进入try岂不是又会造成死锁


