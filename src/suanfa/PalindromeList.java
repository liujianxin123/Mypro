package suanfa;

public class PalindromeList {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
    //第一步找到中点
    //从中点开始将后续结点反转
    //两遍开始next比较直到相遇


    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        if(head.next.next==null){
            return head.val == head.next.val;
        }
        ListNode one = head.next;
        ListNode two = head.next.next;

        while(two.next!=null&&two.next.next!=null){
            one = one.next;
            two = two.next.next;
        }
        //链表倒转
        ListNode pre = null;
        ListNode temp = null;
        while(one!=null){
            temp = one.next;
            one.next = pre;
            pre=one;
            one = temp;
        }
        ListNode tail = pre;
        //头尾比较
        while(head!=null){
            if(head.val!=tail.val) return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node6.setNext(node7);
        node5.setNext(node6);
        node4.setNext(node5);
        node3.setNext(node4);
        node2.setNext(node3);
        node1.setNext(node2);

        System.out.println("===="+isPalindrome(node1));
    }
}
