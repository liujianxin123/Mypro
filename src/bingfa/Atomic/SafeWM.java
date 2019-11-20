package bingfa.Atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 下面的示例代码是合理库存的原子化实现，仅实现了设置库存上限
 * setUpper() 方法，你觉得 setUpper() 方法的实现是否正确呢?
 */
public class SafeWM {
    class WMRange{
        final int upper;
        final int lower;
        WMRange(int upper,int lower){
            // 省略构造函数实现
            this.lower = lower;
            this.upper = upper;
        }
    }
    final AtomicReference<WMRange> rf = new AtomicReference<>(
            new WMRange(0,0)
    );
    // 设置库存上限
    void setUpper(int v){
        WMRange nr;
        WMRange or = rf.get();
        do{
            // 检查参数合法性
            if(v < or.lower){
                throw new IllegalArgumentException();
            }
            nr = new WMRange(v, or.lower);
        }while(!rf.compareAndSet(or, nr));
    }


    //答案：or = rf.get();应该放到do循环内
}

//线程1执行完31行之后，被暂停。
//线程2执行，并成功更新rf的内容。
//线程1继续执行，32行while语句返回为false(因为rf内容已经被线程2更新)。
//线程1重新进入do循环。注意此时or并没有被重新读取。while语句继续返回false，如此往复。
//
//把 WMRange or = rf.get(); 这一行放到 do 内部，就可以了