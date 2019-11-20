package suanfa.ERchashu;

/**
 * 二叉树的常规操作参考https://mp.weixin.qq.com/s/ONKJyusGCIE2ctwT9uLv9g
 */
public class ERChaTreeTest {

    /**
     * 求二叉树的深度
     * 分析过程
     * 只有一个根结点时，二叉树深度为 1
     *
     * 只有左子树时，二叉树深度为左子树深度加 1
     *
     * 只有右子树时，二叉树深度为右子树深度加 1
     *
     * 同时存在左右子树时，二叉树深度为左右子树中深度最大者加 1
     * @param node
     */
    public static int deep(Node node){
        if(node == null){
            return 0;
        }
        int leftnum = deep(node.left);
        int rightnum = deep(node.right);

        return leftnum > rightnum ? leftnum+1:rightnum+1;
    }








    public static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
        }
    }
}
