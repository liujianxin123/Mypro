package suanfa.paixu;

import java.util.Arrays;

/*
 * 插入排序算法：
 * 1、以数组的某一位作为分隔位，比如index=1，假设左面的都是有序的.
 *
 * 2、将index位的数据拿出来，放到临时变量里，这时index位置就空出来了.
 *
 * 3、从leftindex=index-1开始将左面的数据与当前index位的数据（即temp）进行比较，如果array[leftindex]>temp,
 * 则将array[leftindex]后移一位，即array[leftindex+1]=array[leftindex],此时leftindex就空出来了.
 *
 * 4、再用index-2(即leftindex=leftindex-1)位的数据和temp比，重复步骤3，
 * 直到找到<=temp的数据或者比到了最左面（说明temp最小），停止比较，将temp放在当前空的位置上.
 *
 * 5、index向后挪1，即index=index+1，temp=array[index],重复步骤2-4，直到index=array.length,排序结束，
 * 此时数组中的数据即为从小到大的顺序.
 *
 * @author jxliu
 *1 2 6 3 4
 */
public class InsertSort {
    private int[] array;
    private int length;

    public InsertSort(int[] array){
        this.array = array;
        this.length = array.length;
    }

    public void display(){
        for(int a: array){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    /*
     * 插入排序方法
     * 
     */
    public void doInsertSort(){
        for(int index = 1; index<length; index++){//外层向右的index，即作为比较对象的数据的index
            int temp = array[index];//用作比较的数据
            int leftindex = index-1;
            while(leftindex>=0 && array[leftindex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
                array[leftindex+1] = array[leftindex];
                leftindex--;
            }
            array[leftindex+1] = temp;//把temp放到空位上
        }
    }
    //3 1
    public static void cc(int[] p){
        for (int i = 0; i < p.length; i++) {
            int tem = p[i];
            int left = i - 1;
            while (left >= 0 && p[left] > tem){
                p[left + 1] = p[left];
                left--;
            }
            p[left + 1] = tem;
        }
    }


    public static void main(String[] args){
        int[] array = {38,65,97,76,13,27,49};
        InsertSort is = new InsertSort(array);
        System.out.println("排序前的数据为：");
        System.out.println(Arrays.toString(array));
        is.doInsertSort();
        System.out.println("排序后的数据为：");
        System.out.println(Arrays.toString(array));
//        Map m = new HashMap(20);
//        int a = 0100;
//        int b = 1133;
//        int c = a^b;
//        System.out.println("a异或b的值："+ c);
//
//        HashMap<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
//        m.put(3, 11);
//        m.put(1, 12);
//        m.put(5, 23);
//        m.put(2, 22);
//
//        for (Map.Entry<Integer,Integer> e : m.entrySet()) {
//            System.out.println(e.getKey());
//        }
    }


}
