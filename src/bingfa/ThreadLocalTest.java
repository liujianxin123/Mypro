package bingfa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.locks.Lock;

public class ThreadLocalTest {
    static class SafeDateFormat {
        // 定义 ThreadLocal 变量
        static final ThreadLocal<DateFormat> tl=ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        static DateFormat get(){
            return tl.get();
        }
    }

    public static void main(String[] args) {
        // 不同线程执行下面代码
        // 返回的 df 是不同的
        //DateFormat df =SafeDateFormat.get();
        try{

            Thread th1 = new Thread(()->{
                DateFormat df = SafeDateFormat.get();
                System.out.println("t1>>>>>"+df.getClass()+String.valueOf(1<<1));
            },"T1");

            Thread th2 = new Thread(()->{
                DateFormat df = SafeDateFormat.get();
                System.out.println("t2>>>>>"+df.getClass());
            },"T2");

            th1.start();
            th2.start();
        }catch (Exception e){
            e.printStackTrace();
        }



    }



}
