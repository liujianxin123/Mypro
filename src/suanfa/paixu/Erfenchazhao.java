package suanfa.paixu;

import java.util.HashMap;
import java.util.Map;

/**
 * 二分查找
 */
public class Erfenchazhao {

//位运算1>>2等于1除以2的平方，1>>>2也等于1除以2的平方，不同的是负数
//位运算1<<2等于1乘以2的平方

    /**
     * 二分查找，首先保证数组有序
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (high >= low){
            int mid = (low + high)>>>1;//改进的方法是将 mid 的计算方式写成 low+(high-low)>>1,因为如果 low 和 high 比较大的话，两者之和就有可能溢出
            if(a[mid] == value){
                return mid;
            }else if(a[mid] > value){
                high = mid -1;
            }else if(a[mid] < value){
                low = mid +1;
            }
        }

        return -1;
    }
    // 二分查找的递归实现
    public int bsearch2(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid =  low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid+1, high, value);
        } else {
            return bsearchInternally(a, low, mid-1, value);
        }
    }

    /**
     * 二分法求一个数的平方根
     * @param n
     * @param deltaThreshold（deltaThreshold 来控制解的精度）
     * @return
     */
    public static double getSqureRoot(int n, double deltaThreshold) {
        double low = 1.0;
        double high = (double) n;
        while (low <= high) {
            double mid = low + ((high - low) / 2);
            double square = mid * mid;
            double delta = Math.abs(square / n - 1);
            if (delta < deltaThreshold) {
                return mid;
            } else if (square < n) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1.0;
    }

    /**
     * 二分查找有重复数据的第一个值
     * 例如[0,2,4,4,4,5,6,9],查找第一个4出现的位置
     * @param a
     * @param n
     * @param value
     */
    public static int getSqureRoot2(int[] a, int n, int value){
        int low = 0;
        int high = n-1;
        while (low<=high){

            int mid = low + ((high - low)>>1);
            if(a[mid]<value){
                low = mid +1;
            }else if (a[mid] > value){
                high = mid -1;
            }
            else {
                if(mid == 0|| a[mid -1] != value){
                    return mid;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找有重复数据的第一个值
     * 例如[0,2,4,4,4,5,6,9],查找最后一个4出现的位置
     * @param a
     * @param n
     * @param value
     */
    public static int getSqureRoot3(int[] a, int n, int value){
        int low = 0;
        int high = n-1;
        while (low<=high){

            int mid = low + ((high - low)>>1);
            if(a[mid]<value){
                low = mid +1;
            }else if (a[mid] > value){
                high = mid -1;
            }
            else {
                if(mid == 0|| a[mid + 1] != value){
                    return mid;
                }else{
                    low = mid +1;
                }
            }
        }
        return -1;
    }

    /**
     * [3,4,6,7,10],二分查找第一个大于等于5的下标
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int getSqureRoot4(int[] a, int n, int value){
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high - low)>>1);
            if(a[mid] >= value){
                if(mid == 0 || a[mid - 1] < value){
                    return mid;
                }else{
                    high = mid -1;
                }
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * [3,4,6,7,10],二分查找最后一个小于等于5的下标
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int getSqureRoot5(int[] a, int n, int value){
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high - low)>>1);
            if(a[mid] <= value){
                if(mid == 0 || a[mid + 1] > value){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Map m = new HashMap(6);
//       double a =  Erfenchazhao.getSqureRoot(4,4);
//        int[] p = {0,2,4,4,4,5,6,9};
//        int a = Erfenchazhao.getSqureRoot5(p,p.length,4);
//        System.out.println(a);

        System.out.println(getSqureRoot(5,0.01));

    }

}
