package suanfa.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目要求：
 * 给定一个N*M的矩阵，在矩阵中每一块有一张牌，我们假定刚开始的时候所有牌的牌面向上。
 * 现在对于每个块进行如下操作：
 * 翻转某个块中的牌，并且与之相邻的其余八张牌也会被翻转。
 *
 *题目链接：https://www.nowcoder.com/test/question/done?tid=28927848&qid=353479#summary
 *参考博客链接：https://blog.csdn.net/vMars_K/article/details/94995483#commentBox
 *
 * 矩阵的行 N == 1 且 列 M == 1，则只对一个进行翻转，结果为1
 * 矩阵的行 N == 1，列 M > 1（M == 1, N > 1也一样），则除去首位两个边线的点，输出 M-2（N-2）
 * 矩阵的行 N > 1 且 列 M > 1, 则除去四周边线的点，输出 (M-2)*(N-2)
 *
 */
public class Fanzhuan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] p = br.readLine().split(" ");
        if(p.length == 1){
            p[p.length] = "1";
        }
        Long n = Long.valueOf(p[0]);
        Long m = Long.valueOf(p[1]);
        if(n == 1 && m ==1){
            System.out.println(1);
        } else if (n ==1 && m >1 ||(n >1 && m == 1)) {
            System.out.println(n > 1? n-2 : m-2);
        }else if(m>1 && n>1){
            System.out.println((m-2)*(n-2));
        }

    }
}
