package suanfa.liku;

import java.util.Arrays;

// 基于数组实现的顺序栈
public class MinStack {
    private int[] items;  // 数组
    private int count;       // 栈中元素个数
    private int n;           // 栈的大小

    // 初始化数组，申请一个大小为 n 的数组空间
    public MinStack(int n) {
        this.items = new int[n];
        this.n = n;
        this.count = 0;
    }

    // 入栈操作
    public void push(int x) {
        // 数组空间不够了，直接返回 false，入栈失败。
        if (count < n){
            // 将 item 放到下标为 count 的位置，并且 count 加一
            items[count] = x;
            ++count;
        }
    }

    // 出栈操作
    public int top() {
        // 栈为空，则直接返回 null
        if (count == 0) return -1;
        // 返回下标为 count-1 的数组元素，并且栈中元素个数 count 减一
        int tmp = items[count-1];
        --count;
        return tmp;
    }

    //删除栈顶元素
    public void pop() {
        // 栈为空，则直接返回 null
        if (count > 0){
            // 返回下标为 count-1 的数组元素，并且栈中元素个数 count 减一
            int tmp = items[count-1];
            --count;
        }
    }

    //检索栈中的最小元素
    public int getMin() {
        quickSort(items, 0, items.length-1);
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        System.out.println();
        return items[0];
    }



    public void quickSort(int[] arr,int low,int high){

    }
    public static void main(String[] args) {
        MinStack a = new MinStack(4);

        a.push(3);
        a.push(4);
        a.push(3);
        a.push(0);
        System.out.println("-----------------------");
        System.out.println("取得栈中的最小值:"+a.getMin());
    }
}


