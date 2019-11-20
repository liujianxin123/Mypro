package suanfa.zifuchuanpipei;

public class BFsuanfa {
    public static void main(String[] args) {
        String a = "accbaaaccssdd";
        String b = "acc";
        System.out.println(find(a, b));
//        System.out.println(bfFind(a, b, 3));
    }
    public static int bfFind(String S, String T, int pos) {
        char[] arr1 = S.toCharArray();
        char[] arr2 = T.toCharArray();
        int i = pos;
        int j = 0;
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] == arr2[j]) {
                i++;
                j++;
            }
            else {
                i = i - j + 1;
                j = 0;
            }
        }
        if(j == arr2.length) return i - j;
        else return -1;
    }
    public static int find(String str1,String str2){
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int i=0;
        int j;
        while(i<str1.length()-1){
            j = 0;
            while(c1[i]==c2[j]&& j< str2.length()-1){
                i++;
                j++;
            }
            if(j==str2.length()-1){
                return i - str2.length()+1;
            }
            i=i-j+1;

        }
        return -1;
    }


    private static final int SIZE = 256; // 全局变量或成员变量
    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; ++i) {
            bc[i] = -1; // 初始化 bc
        }
        for (int i = 0; i < m; ++i) {
            int ascii = (int)b[i]; // 计算 b[i] 的 ASCII 值
            bc[ascii] = i;
        }
    }

    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
        generateBC(b, m, bc); // 构建坏字符哈希表
        int i = 0; // i 表示主串与模式串对齐的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i+j] != b[j]) break; // 坏字符对应模式串中的下标是 j
            }
            if (j < 0) {
                return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            }
            // 这里等同于将模式串往后滑动 j-bc[(int)a[i+j]] 位
            i = i + (j - bc[(int)a[i+j]]);
        }
        return -1;
    }

}
