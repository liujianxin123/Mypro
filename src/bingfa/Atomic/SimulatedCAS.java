package bingfa.Atomic;

class SimulatedCAS{
    volatile int count;
    // 实现 count+=1
    void addOne(){
//        do {
//            newValue = count+1; //①
//        }while(count != cas(count,newValue); //②


        //对比着看
//        do{
//            int oldValue = count;
//            int newValue = oldValue + 1;
//        }while(oldValue != cas(oldValue, newValue));
    }
    // 模拟实现 CAS，仅用来帮助理解
    synchronized int cas(int expect, int newValue){
        // 读目前 count 的值
        int curValue = count;
        // 比较目前 count 值是否 == 期望值
        if(curValue == expect){
            // 如果是，则更新 count 的值
            count= newValue;
        }
        // 返回写入前
        //
        //
        // `12的
        return curValue;
    }


    //执行addOne方法的时候相当于把当前的count保存到一个临时变量oldcount中
    //线程1执行cas的时候，判断这时候的count的值是否被其他线程改变了，用oldcount和当前的count
    //比较，如果相同就更新count的值，再将写入前的值返回，while判断写入前的值等于临时存的旧的值
    //就结束循环，此时不能说明count的值没有发生改变，因为可能发生了ABA的问题，就是count由A变成B
    //再由B变成A
}
