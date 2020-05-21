package suanfa.liku;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
//        System.out.println(Solution.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(Solution.isValid("{"));


//        int[] a1 = {2,3,4},a2 = {2,4,1,8,3,0};
//        System.out.println(nextGreaterElement(a1,a2));

        pingfen();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


    //第20题，栈的应用
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
        public static boolean isValid(String p) {
            Stack<Character> s = new Stack<Character>();
            char[] chars = p.toCharArray();
            for(char c : p.toCharArray()){
                if(c == '('){
                    s.push(')');
                }else if(c == '{'){
                    s.push('}');
                }else if(c == '['){
                    s.push(']');
                }else if(s.isEmpty() || s.pop() != c){
                    return false;
                }
            }
            return s.isEmpty();
        }



    //2,3,4
    //2,4,1,8,3,0
    //结果4，-1，8
//    先遍历大数组nums2，首先将第一个元素入栈；
//    继续遍历，当当前元素小于栈顶元素时，继续将它入栈；当当前元素大于栈顶元素时，栈顶元素出栈，此时应将该出栈的元素与当前元素形成key-value键值对，存入HashMap中；
//    当遍历完nums2后，得到nums2中元素所对应的下一个更大元素的hash表；
//    遍历nums1的元素在hashMap中去查找‘下一个更大元素’，当找不到时则为-1。
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();

        int[] result = new int[nums1.length];

        for(int num : nums2) {
            while(!stack.isEmpty() && stack.peek()<num){
                hasMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for(int i = 0; i < nums1.length; i++) result[i] = hasMap.getOrDefault(nums1[i], -1);

        return result;
    }


        public int[] test(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i<nums.length;i++){
                int tmp = target - nums[i];
                if(map.containsKey(tmp)){
                    return new int[]{map.get(tmp),i};   //存在即返回
                }
                map.put(nums[i],i);  //不存在，则加入
            }
            throw new IllegalArgumentException("No two sum solution");
        }


    /**
     * 给任意一个数组，去掉最大值和最小值求剩下数的平均数
     */
    public static void pingfen(){


        char[] p = {9,2,5,4,3};
        int max = p[0];
        int min = p[p.length-1];
        int count = 0;
        for (int i = 0; i < p.length; i++) {
            count += p[i];
            if(max < p[i]){
                max = p[i];
            }
            if(min > p[i]){
                min = p[i];
            }
        }

        int num = (count - min -max)/(p.length -2);

        System.out.println(num);
    }


}
