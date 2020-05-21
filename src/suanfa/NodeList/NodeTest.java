package suanfa.NodeList;

import suanfa.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class NodeTest {
    public static void main(String[] args) {

        Node head = new Node("null");
        Node d = new Node("a");
        Node a = new Node("v");
        Node b = new Node("v");
        Node c = new Node("a");
        head.setNext(d);
        d.setNext(a);
        a.setNext(b);
        b.setNext(c);

        boolean flag = NodeTest.isPalindrome(head);
        System.out.println(flag);

    }
    public static boolean isPalindrome(Node head){

        Stack<Node> stack = new Stack<Node>();
        Node head1 = head.getNext();
        while (head1 != null){
            stack.add(head1);
            head1 = head1.getNext();
        }
        while (head1 != null) {
            if(head1.getData() != stack.pop().getData()){
                return false;
            }
            head1 = head1.getNext();
        }
        return true;
    }


    /**
     * 遍历反转，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public static Node reverse2(Node head) {
        if (head == null)
            return head;
        Node pre = head;// 上一结点
        Node cur = head.getNext();// 当前结点
        Node tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向

            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);

        return pre;
    }



    /**
     * 递归反转，在反转当前节点之前先反转后续节点
     * 我们来看是怎样的一个递归过程：1->2->3->4
     *
     * 程序到达Node newHead = reverse(head.next);时进入递归
     * 我们假设此时递归到了3结点，此时head=3结点，temp=3结点.next(实际上是4结点)
     * 执行Node newHead = reverse(head.next);传入的head.next是4结点，返回的newHead是4结点。
     * 接下来就是弹栈过程了
     * 程序继续执行 temp.next = head就相当于4->3
     * head.next = null 即把3结点指向4结点的指针断掉。
     * 返回新链表的头结点newHead
     */
//    public static Node Reverse1(Node head) {
//        if (head == null || head.next == null)
//            return head;
//        Node temp = head.next;
//        Node newHead = Reverse1(head.next);
//        temp.next = head;
//        head.next = null;
//        return newHead;
//    }



    public static Node reverseListNode(Node head){
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.getNext() == null){
            return head;
        }
        //前一个节点指针
        Node preNode = null;
        //当前节点指针
        Node curNode = head;
        //下一个节点指针
        Node nextNode = null;

        while (curNode != null){
            nextNode = curNode.getNext();//nextNode 指向下一个节点
            curNode.setNext(preNode);//将当前节点next域指向前一个节点
            preNode = curNode;//preNode 指针向后移动
            curNode = nextNode;//curNode指针向后移动
        }

        return preNode;
    }

    public void tett(){

        // 创建FutureTask
        FutureTask<List> futureTask1 = new FutureTask<List>(()-> {
            List<Map<String,Object>> lists2 = new ArrayList<Map<String, Object>>();

            List<Map<String,Object>> lists1 = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < 25; i++) {
                lists2.add(lists2.get(i));
            }
            return lists2;
        });
        // 创建并启动线程
        Thread T1 = new Thread(futureTask1);
        T1.start();

        FutureTask<List> futureTask2 = new FutureTask<List>(()-> {
            List<Map<String,Object>> lists2 = new ArrayList<Map<String, Object>>();

            List<Map<String,Object>> lists1 = new ArrayList<Map<String, Object>>();
            for (int i = 26; i < 50; i++) {
                lists2.add(lists2.get(i));
            }
            return lists2;
        });
        // 创建并启动线程
        Thread T2 = new Thread(futureTask2);
        T2.start();

        // 获取计算结果
        try {
            List<Map<String,Object>> result1 = futureTask1.get();
            List<Map<String,Object>> result2 = futureTask2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



        // 创建FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(()-> 1+2);
        // 创建线程池
        ExecutorService es = Executors.newCachedThreadPool();
        // 提交FutureTask
        es.submit(futureTask);
        // 获取计算结果
//        Integer result = futureTask.get();

    }

}
