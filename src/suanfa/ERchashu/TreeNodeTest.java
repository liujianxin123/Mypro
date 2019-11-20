package suanfa.ERchashu;

import suanfa.ERchashu.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class TreeNodeTest {
    public static void main(String[] args) {
        TreeNode[] node = new TreeNode[10];//以数组形式生成一棵完全二叉树
        for(int i = 0; i < 10; i++)
        {
            node[i] = new TreeNode(i);
        }
        for(int i = 0; i < 10; i++)
        {
            if(i*2+1 < 10)
                node[i].setLeft(node[i*2+1]);
            if(i*2+2 < 10)
                node[i].setRight(node[i*2+2]);
        }

        postOrderRe(node[0]);
        System.out.println("-------------------------");
        houxuSort(node[0]);
    }

    /**
     * 前序遍历首先访问根结点然后遍历左子树，最后遍历右子树。
     * 在遍历左、右子树时，仍然先访问根结点，然后遍历左子树，最后遍历右子树。
     * @param biTree
     */
    public static void preOrder(TreeNode biTree)
    {//非递归实现
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(biTree != null || !stack.isEmpty())
        {
            while(biTree != null)
            {
                System.out.println(biTree.getValue());
                stack.push(biTree);
                biTree = biTree.getLeft();
            }
            if(!stack.isEmpty()) {
                biTree = stack.pop();
                biTree = biTree.getRight();
            }
        }
    }

    /**
     * 递归实现
     * @param biTree
     */
    public static void preOrderRe(TreeNode biTree) {
        System.out.println(biTree.getValue());
        TreeNode leftTree = biTree.getLeft();
        if(leftTree != null) {
            preOrderRe(leftTree);
        }
        TreeNode rightTree = biTree.getRight();
        if(rightTree != null) {
            preOrderRe(rightTree);
        }
    }

    /**
     * 中序遍历递归实现
     * @param biTree
     */
    public static void midOrderRe(TreeNode biTree) {
        if(biTree == null)
            return;
        else
        {
            midOrderRe(biTree.getLeft());
            System.out.println(biTree.getValue());
            midOrderRe(biTree.getRight());
        }
    }

    /**
     * 中序遍历非递归实现
     * @param biTree
     */
    public static void midOrder(TreeNode biTree) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(biTree != null || !stack.isEmpty())
        {
            while(biTree != null)
            {
                stack.push(biTree);
                biTree = biTree.getLeft();
            }
            if(!stack.isEmpty())
            {
                biTree = stack.pop();
                System.out.println(biTree.getValue());
                biTree = biTree.getRight();
            }
        }
    }


    /**
     * 后序遍历递归实现
     * @param biTree
     */
    public static void postOrderRe(TreeNode biTree) {
        if(biTree == null)
            return;
        else
        {
            postOrderRe(biTree.getLeft());
            postOrderRe(biTree.getRight());
            System.out.println(biTree.getValue());
        }
    }

    /**
     * 后序遍历非递归实现
     * @param biTree
     */
    public static void postOrder(TreeNode biTree) {
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。

        while(biTree != null || !stack.empty())
        {
            while(biTree != null)
            {//将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(biTree);
                stack2.push(left);
                biTree = biTree.getLeft();
            }

            while(!stack.empty() && stack2.peek() == right)
            {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.println(stack.pop().getValue());
            }

            if(!stack.empty() && stack2.peek() == left)
            {//如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                biTree = stack.peek().getRight();
            }

        }
    }


    public static void qianxuSort(TreeNode treeNode){

        if(treeNode == null){
            return;
        }
        System.out.println(treeNode.getValue());
        if(treeNode.getLeft() != null){
            qianxuSort(treeNode.getLeft());
        }
        if(treeNode.getLeft() != null){
            qianxuSort(treeNode.getRight());
        }
    }


    public static void zhongxuSort(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        if(treeNode.getLeft() != null){
            zhongxuSort(treeNode.getLeft());
        }

        System.out.println(treeNode.getValue());
        if(treeNode.getRight() != null){
            zhongxuSort(treeNode.getRight());
        }
    }

    public static void houxuSort(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        if(treeNode.getLeft() != null){
            houxuSort(treeNode.getLeft());
        }

        if(treeNode.getRight() != null){
            houxuSort(treeNode.getRight());
        }

        System.out.println(treeNode.getValue());

    }


    public static void levelOrder(TreeNode biTree) {//层次遍历
        if(biTree == null)
            return;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(biTree);
        TreeNode currentNode;
        while(!list.isEmpty())
        {
            currentNode = list.poll();
            System.out.println(currentNode.getValue());
            if(currentNode.getLeft() != null)
                list.add(currentNode.getLeft());
            if(currentNode.getRight() != null)
                list.add(currentNode.getRight());
        }
    }

}
