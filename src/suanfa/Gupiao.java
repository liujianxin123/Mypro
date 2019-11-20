package suanfa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入 : [7, 1, 5, 3, 6, 4]
 * 输出 : 5
 * 解释 : 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，
 * 最大利润 = 6 - 1 = 5 。
 * 注意利润不能是 7 - 1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2 :
 *
 * 输入 : [7, 6, 4, 3, 1]
 * 输出 : 0
 * 解释 : 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 */
public class Gupiao {

        public static void main(String[] args) {
//            int[] prices = {7,1,5,3,6,4};
//            int[] prices2 = {7,6,4,3,1};
//            System.out.println(maxNum(prices2));

            int[] t = {2,4,11,15,7};
            System.out.println(Arrays.toString(twoSum(t,9)));

        }

    /**
     * 时间复杂度为O(n2)
     * @param prices
     * @return
     */
    public static int maxNum(int[] prices){
            if (prices == null || prices.length ==0 || prices.length ==1) {
                return 0;
            }
            int tem = prices[0];
            int c = 0;
            int d = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i+1;j < prices.length; j++){
                    int c1 = prices[j] - tem;
                    if(c1 > c){
                        c = c1;
                    }
                }
                if(d < c){
                    d = c;
                }
                tem = prices[i+1];
            }
            return d;
        }

    public static int[] twoSum(int[] nums, int target) {
        int[] p = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    p[0] = nums[i];
                    p[1] = nums[j];
                    return p;
                }
            }
        }

        return p;
    }
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack s1 = new Stack();
        ListNode n1 = l1.next;
        while (n1 != null){
            s1.push(n1);
            n1 = n1.next;
        }
        Stack s2 = new Stack();
        ListNode n2 = l2.next;
        while (n2 != null){
            s2.push(n2);
            n2 = n2.next;
        }
        String a1 = "";
        while (s1.size()>0){
            a1+=s1.pop();
        }
        String a2 = "";
        while (s2.size()>0){
            a2+=s2.pop();
        }
        int num = Integer.valueOf(a1) + Integer.valueOf(a2);



        return null;
    }

    public void reverseLinkList_Stack(ListNode head) {  //借助栈来实现逆序输出
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node = head.next;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (stack.size() > 0) {
            node = stack.pop();
            System.out.print(node.getData() + "--->");
        }
        System.out.println("null"); // 在最后添加上null作为结束标志
    }

    private static class ListNode {
        private String data;
        private ListNode next;

        public ListNode(String data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}
