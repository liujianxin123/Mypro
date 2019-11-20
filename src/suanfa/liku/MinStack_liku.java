package suanfa.liku;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.concurrent.*;

//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//
//        push(x) -- 将元素 x 推入栈中。
//        pop() -- 删除栈顶的元素。
//        top() -- 获取栈顶元素。
//        getMin() -- 检索栈中的最小元素。

/**
 * 思路：利用空间换时间的思想,每次入栈两个元素，一个是这个元素的本身，另一个是这个栈中目前为止最小的值
 * 比如：2-3-1，先入栈2，因为是第一个元素，所以这时候栈中最小的数是他本身，入栈3判断这个栈中比三小的第一个元素是2
 * 再把2入栈，这时候栈中的元素为2->2->3->2,栈顶为2，再入栈1，1比2小，然后入栈1，最终的栈为2->2->3->2->1->1
 */
public class MinStack_liku {

    private Stack<Integer> stack;

    public MinStack_liku() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {

        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else{
            int tmp = stack.peek();
            stack.push(x);
            if(tmp<x){
                stack.push(tmp);
            }else{
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size()-2);
    }

    public int getMin() {
        return stack.peek();
    }
    public void aa(){


    }

//
//    // 创建FutureTask
//    FutureTask<Integer> futureTask
//            = new FutureTask<>(()-> 1+2);
//    // 创建线程池
//    ExecutorService es =
//            Executors.newCachedThreadPool();
//// 提交FutureTask
//es.submit(futureTask);
//    // 获取计算结果
//    Integer result = futureTask.get();


    public static String thread(){
        ArrayBlockingQueue<Runnable> blockingDeque = new ArrayBlockingQueue<>(4);
        ExecutorService es = new ThreadPoolExecutor(2,4,1000,TimeUnit.MILLISECONDS,blockingDeque);
        String result = null;
        boolean flag = true;
        int i = 0;
        while (flag){

            try {

                // 创建FutureTask
                FutureTask<String> futureTask= new FutureTask<String>(()->{
                    return "结束";
                });
                // 创建并启动线程
//                Thread t = new Thread(futureTask);
//
//                t.start();
                System.out.println(Thread.currentThread().getName()+"将要执行");
                es.submit(futureTask);
                // 获取计算结果
                result = futureTask.get();

                System.out.println(i++);
                if(i == 5){
                    flag = false;
                    es.shutdown();
                }else{
                    Thread.currentThread().sleep(1000);

                }

            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;

    }

    public static void main(String[] args) {

//        Thread t1 = new Thread(()->{
//            System.out.println(thread());
//        });
//        Thread t2 = new Thread(()->{
//            System.out.println(thread());
//        });
//        Thread t3 = new Thread(()->{
//            System.out.println(thread());
//        });
//        Thread t4 = new Thread(()->{
//            System.out.println(thread());
//        });
//        Thread t5 = new Thread(()->{
//            System.out.println(thread());
//        });
//        Thread t6 = new Thread(()->{
//            System.out.println(thread());
//        });
//        Thread t7 = new Thread(()->{
//            System.out.println(thread());
//        });
//        Thread t8 = new Thread(()->{
//            System.out.println(thread());
//        });
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        t7.start();
//        t8.start();


        String a = "";
    }


    private static String mend(String target) {
        char[] chars = target.toCharArray();
        StringBuilder builder = new StringBuilder();
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            chars[k] = chars[i];
            builder.append(chars[k]);
            k++;
            // 先满足规则1
            if (k >= 3 && chars[k-3] == chars[k-2] && chars[k-2] == chars[k-1]) {
                builder.deleteCharAt(k-1);
                k--;
            }
            // 再满足规则2
            if (k >= 4 && chars[k-4] == chars[k-3] && chars[k-2] == chars[k-1]) {
                builder.deleteCharAt(k-1);
                k--;
            }
        }
        return String.valueOf(builder);
    }

}
