package suanfa.paixu;

public class Maopao {
    public static void maopao(int[] p){
        for (int i = 0; i < p.length -1; i++) {
            boolean flag = false;
            for (int j = 0; j < p.length - i -1; j++) {
                if(p[j]>p[j+1]){
                    int tem = p[j+1];
                    p[j+1]=p[j];
                    p[j] = tem;
                    flag = true;
                }
            }
            if(!flag)break;
        }
    }


    public static int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f(n-1) + f(n-2);
    }

    public static void main(String[] args) {
        int t = Maopao.f(5);
        System.out.println(t);
    }



    // 插入排序，a表示数组，n表示数组大小
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }
}
