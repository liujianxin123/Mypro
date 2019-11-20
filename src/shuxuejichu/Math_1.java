package shuxuejichu;

import java.math.BigInteger;

public class Math_1 {

    public static void main(String[] args) {

        int a = 53;
        int b = 53;
        System.out.println(27*12*0.7);
        System.out.println(Math_1.and(a,b));
    }


    public static void test(int a,int b){

        System.out.println(String.format("数字%d的向左位移%d位是%d",a,b,a<<b));
        System.out.println(String.format("数字%d的向右位移%d位是%d",a,b,a>>>b));
    }


    /**
     * @Description: 二进制按位“或”的操作
     * @param num1-第一个数字，num2-第二个数字
     * @return 二进制按位“或”的结果
     */
    public static int or(int num1, int num2) {

        return (num1 | num2);

    }

    /**
     * @Description: 二进制按位“与”的操作
     * @param num1-第一个数字，num2-第二个数字
     * @return 二进制按位“与”的结果
     */
    public static int and(int num1, int num2) {

        return (num1 & num2);

    }

    /**

     * @Description: 二进制按位“异或”的操作
     * @param num1-第一个数字，num2-第二个数字
     * @return 二进制按位“异或”的结果
     */

    public static int xor(int num1, int num2) {

        return (num1 ^ num2);

    }


/**
 * 二分法
 * @param p
 * @param t
 * @return
 */
    public int erfen(int[] p,int t){

        int begin = 0;
        int end = p.length-1;

        while (end >begin){
            int mid = begin+(end-begin)>>>1;
            if(p[mid] > t){
                end = mid;
            }else if(p[mid]<t){
                end = mid+1;
            }
            else return p[mid];
        }
        return -1;
    }

    /**
     * 求一个数的平方根
     * @param p 要求平方根的数
     * @param j 精度
     * @return
     */
    public static double erfen2(double p,double j){
        double star = 0.0;
        double end = p;
        while (star<end){
            double mid = star + (end-star)/2;
            double tem = mid*mid;
            double jingdu =Math.abs(tem/p -1);//精度

            if (jingdu < j){
                return mid;
            }
            else if (tem < p) end = mid;
            else if (tem > p) star = mid;
        }
        return -1;
    }
}
