package suanfa;

import java.util.Stack;

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
     */
    public static Node Reverse1(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        Node reHead = Reverse1(head.getNext());// 先反转后续节点head.getNext()
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }

//    long findRootReferrerId(long actorId) {
//        Long referrerId = "select referrer_id from [table] where actor_id = actorId";
//        if (referrerId == null) return actorId;
//        return findRootReferrerId(referrerId);
//    }



}
