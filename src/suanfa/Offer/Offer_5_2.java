package suanfa.Offer;

import java.util.Arrays;

//有两个排序的数组A1和A2,内存在A1的末尾有足够的空间来容纳数组A2,
// 请实现一种函数，把A2的所有数字插入到A1中并且所有的数字是排序的
//1，4，5，8
//2，4，6，7
public class Offer_5_2 {

    public static void main(String[] args) {

        int[] a = {1,4,5,8};
        int[] b = {2,4,6,7};


        System.out.println(Offer_5_2.replace(a,b));
    }

    public static String replace(int[] p1,int[] p2){
        int newIndex = p1.length+p2.length-1;
        int l1 = p1.length-1;

        int newlenth = p1.length+p2.length;
        p1 = Arrays.copyOf(p1,newlenth);

        int l2 = p2.length-1;

        while (newIndex > 0){
            if(p1[l1]>p2[l2]){
                p1[newIndex--] = p1[l1];
                p1[newIndex--] = p2[l2];
            }else{
                p1[newIndex--] = p2[l2];
                p1[newIndex--] = p1[l1];
            }
            l1--;
            l2--;

        }

        return Arrays.toString(p1);
    }

}
