package suanfa.Offer;
//从上往下打印出二叉树的每个节点，同层节点从左至右打印
//思路：


import suanfa.ERchashu.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Offer_20 {

    public List<Integer> getnode(TreeNode node){
        List<Integer> nodes = new ArrayList<Integer>();
        if (node == null) return nodes;
        LinkedList<TreeNode> queues = new LinkedList<TreeNode>();
        queues.add(node);

        while (!queues.isEmpty()){
            TreeNode head = queues.poll();
            nodes.add(head.getValue());

            if(head.getLeft()!= null){
                queues.add(head.getLeft());
            }

            if(head.getRight()!=null){
                queues.add(head.getRight());
            }
        }

        return nodes;
    }

    public void aqs(){
        ReentrantLock lock = new ReentrantLock();
    }
}
