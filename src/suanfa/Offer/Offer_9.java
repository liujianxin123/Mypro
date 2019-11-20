package suanfa.Offer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

//用两个栈实现一个队列
public class Offer_9 {
    private static Stack<String> stack1 = null;
    private static Stack<String> stack2 = null;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] p = br.readLine().split(",");
        for (int i = 0; i < p.length; i++) {
            Offer_9.reput(p[i]);
        }

    }

    public static void reput(String a){
        stack1 = new Stack<String>();
        stack2 = new Stack<String>();
        stack1.push(a);

        if(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        if(!stack2.isEmpty()){
            System.out.println(stack2.pop());
        }

    }






}
