package suanfa;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.getNext() == null) {
            return true;
        }

        ListNode prev = null;
        ListNode slow = head;//慢指针
        ListNode fast = head;//快指针

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            ListNode next = slow.getNext();
            //slow.getNext() = prev;
            slow.setNext(prev);
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            if (slow.getData() != prev.getData()) {
                return false;
            }
            slow = slow.getNext();
            prev = prev.getNext();
        }

        return true;
    }
}
