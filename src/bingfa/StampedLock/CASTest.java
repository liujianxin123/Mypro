package bingfa.StampedLock;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * cas 模拟伪代码
 */
public class CASTest {
        int count;
        synchronized int cas(int expect, int newValue){
            // 读目前 count 的值
            int curValue = count;
            // 比较目前 count 值是否 == 期望值
            if(curValue == expect){
                // 如果是，则更新 count 的值
                count = newValue;
            }
            // 返回写入前的值
            return curValue;
        }

    public static void main(String[] args) {
//        int i = 1;
//        do {
//            System.out.println(i);
//            i = i+1;
//        }while (i>1);

        String a = new String("a");
        String b = "a";
        System.out.println(a == b);
    }
}
