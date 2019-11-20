package suanfa.niuke;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class minNum {

    //最小代价
    public static void test(String s){
        String[] p = s.split(" ");

        int[] a = new int[p.length];
        int i = 0;
        for(String ps : p){
            a[i++] = Integer.valueOf(ps);
        }

        Arrays.sort(a);
        System.out.println(Math.abs(a[0]-a[a.length-1]));
    }

    //最小步数
    public static void test2(int b){

        if(b<5){
           System.out.println(1);
        }else if(b%5>0){
            System.out.println(b/5+1);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String s = b.readLine();
        test(s);

    }


}
