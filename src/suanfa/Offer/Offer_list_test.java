package suanfa.Offer;

import java.util.List;
import java.util.Stack;

public class Offer_list_test {
    class ListNode{
        private int value;
        private ListNode next;
        private ListNode(int value,ListNode next){
            this.next = next;
            this.value = value;
        }
        private ListNode(int value){
            this.value = value;
        }
    }

    /**
     * 增加节点
     */
    ListNode head = null;
    public void addNode(int value){
        ListNode newNode = new ListNode(value);

        if(head == null){
            head = newNode;
        }else{
        ListNode tmp = head;
            while (head.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
    }

    /**
     * 删除节点
     * @param value
     */
    public void deleted(int value){

        if(value == head.value){
            head = head.next;
        }else {
            ListNode tmp = head;
            while (tmp.next != null){
                if(tmp.next.value == value){
                    tmp.next = tmp.next.next;
                }
                tmp = tmp.next;
            }
        }

    }


    /**
     * 链表反转
     * https://www.cnblogs.com/keeya/p/9218352.html
     * @param head
     * @return
     */
    public ListNode reback(ListNode head){
        if(head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode next = null;
        while (head.next != null){
            next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 递归反转
     * @param head
     * @return
     */
    public ListNode reserver(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = reserver(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public void useStack(ListNode head){
        if(head == null || head.next == null){
            return;
        }

        Stack stack = new Stack();

        while (head.next != null){
            stack.push(head.next);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

}
