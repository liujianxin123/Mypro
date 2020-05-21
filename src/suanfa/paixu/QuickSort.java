package suanfa.paixu;

import java.util.Arrays;
import java.util.List;

public class QuickSort {
    static int num = 0;
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){//递归的终止条件
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
        System.out.println("循环了》》》》》"+ num++);
    }


    public static void main(String[] args){
        int[] arr = {2,1,3,4,0,5};
        sortPatams_k(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void helanguoqi(){
        int[] params = {0,2,2,1,0,1};
        int k = 1;

        int leftIndex = 0;//左边指针
        int rightIndex = params.length-1;//右边指针

        while (leftIndex < rightIndex){

            //先遍历右边
            while (k<=params[rightIndex] && leftIndex < rightIndex){
                rightIndex--;
            }
            //再遍历左边
            while (k>=params[leftIndex] && leftIndex < rightIndex){
                leftIndex++;
            }
            if(leftIndex < rightIndex){
                int t = params[rightIndex];
                params[rightIndex] = params[leftIndex];
                params[leftIndex] = t;
            }

        }

        System.out.println(Arrays.toString(params));


    }



    public static int[] partition(int[] arr,int l,int r,int num){
        //小于num的区域
        int less = l-1;
        //大于num的区域
        int more = r+1;
        //确保数组不为空或者长度为1
        if(l<r){
            //结束条件为没有没被查询过的数
            while(l<more){
                //如果当前查询的数小于给定的num，将小于num的区域的下一位与当前数交换，并且将小于num的区域+1
                if(arr[l]<num){
                    swap(arr,++less,l++);
                }else if(arr[l]>num){//同上
                    swap(arr,--more,l);
                }else{//若是遇到等于num的数，直接跳过
                    l++;
                }
            }
        }
        //返回的是等于num的数的区域的下标，也就是从less的下一个，到more的前一个
        return new int[]{ less+1,more-1 };
    }



    //交换数组内两个数的位置
    public static void swap(int[] arr,int i,int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 快速排序时间复杂度为O(logn)
     */
    public static void sortPatams_k(int[] params,int low,int high){

        int i,j,tem;
        if(low > high){//递归终止条件
            return;
        }
        i = low;//左边对比指针
        j = high;//右边对比指针
        tem = params[low];//

        while (i < j){
            while (params[j] >= tem && i < j){//先从右边开始,判断右边的是否大于基准位并j--，不是则结束循环;
                j--;
            }
            while (params[i] <= tem && i < j){//再从左边开始判断，判断左边的是否小于基准，并i++,不是则跳出循环
                i++;
            }
            if(i < j){
                int t = params[j];
                params[j] = params[i];
                params[i] = t;
            }
        }

        //将基准的值和i的位置互换
        params[low] = params[i];
        params[i] = tem;

        sortPatams_k(params,low,j-1);
        sortPatams_k(params,j+1,high);
        System.out.println("循环了---->"+ num++);

    }



}
