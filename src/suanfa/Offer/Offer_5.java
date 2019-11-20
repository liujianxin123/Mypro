package suanfa.Offer;




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 面试题5：替换空格
// 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。
//例如输入“We are happy.”，
// 则输出“We%20are%20happy.”。
public class Offer_5 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String p = br.readLine();

        StringBuilder s = new StringBuilder();
        s.setLength(2);

        System.out.println(Offer_5.replace(p));

    }


    public static String replace(String p){

        char[] pars = p.toCharArray();
        int num = 0;

        for (int i = 0; i < pars.length; i++) {
            if(pars[i] == ' '){
                num++;
            }
        }
        int now = pars.length + num*2;//现在字符串的长

        int nowindex = now -1;//现在字符串的索引
        int oldindex = pars.length -1;//原来字符串的索引


        pars = Arrays.copyOf(pars,now);//对原来的数组进行扩容


        while (oldindex>=0 && nowindex > oldindex){

            if(pars[oldindex] != ' '){
                pars[nowindex--] = pars[oldindex];
            }else{
                pars[nowindex--] = '0';
                pars[nowindex--] = '2';
                pars[nowindex--] = '%';
            }
            oldindex--;
        }

        return String.valueOf(pars);
    }
}
