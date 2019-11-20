package suanfa.Offer;
//        PreOrder: GDAFEMHZ
//        InOrder: ADEFGHMZ
//        PostOrder: AEFDHZMG
//        1，因为前序遍历的第一个节点一定是一个二叉树的根，所以从前序的第一个数据开始也就是G，把G映射到中序序列中，
//          并记下在中序序列中的位置（这个位置十分重要！这个位置如果不在中序序列的最左端说明：前序序列中G的下一个数据必定是G的左子树），
//          又因为在中序序列中是按照leftChild—root—rightChild的方式遍历的所以在中序中以上面记下的位置为分界，
//          得到以G为根的左右子树（分别是ADEF和HMZ）。
//        2，上面第一步只是把整个二叉树分出左右子树，然后再在前序中找到下一个数据也就是D，
//          再把D在中序中对应的位置记录下来，此时，D的位置并不在中序序列的最左端（最左端是A），
//          也就说明D还可以继续向下‘派生’左子树，那么继续访问前序序列中的下一个元素也就是A。
//        3，同样的步骤，A在中序序列中的位置处于最左端（即A的左子树长度为0），这说明A不能够再有左子树，
//          此时便可以把A的左子树置为nullptr，这时候再考虑A的右子树是否存在，因为在中序序列中A的右面是D，
//          但是D是A的父节点（这个地方看代码会更易于理解，因为代码中明确的显示出A的右子树长度也为0），所以A的右子树置为nullptr。
//        4，类似的方式再考虑D的右子树存在问题，如果右子树长度不是0，那么就在前序中选出相应的数据……
//        5，……
//原文链接：https://blog.csdn.net/weixin_37818081/article/details/78498156
public class Offer_7 {
    class TreeNode{
        private  int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val,TreeNode left, TreeNode right){
            this.left = left;
            this.right = right;
            this.val = val;
        }
        public TreeNode(int val){
            this.val = val;
        }
    }

    /**
     *
     *
     * @param pre 前序数组
     * @param in  中序数组
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null) {
            // empty param
            return null;
        }

        int preLen = pre.length;
        int inLen = in.length;

        if (preLen != inLen) {
            // inValid param
            return null;
        }

        // 只有一个元素
        if (preLen == 1) {
            return new TreeNode(pre[0]);
        }

        return reConstructBinaryTree(pre, 0, preLen-1, in, 0, inLen-1);
    }


    // 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        // 1、根节点的值
        int rootVal = pre[startPre];

        // 2、找到该值在中序序列中的索引
        int rootIdxInOrder = -1;
        for (int i=startIn; i<= endIn; i++) {
            if (in[i] == rootVal) {
                rootIdxInOrder = i;
                break;
            }
        }
        // 没找到，参数不合法，返回null
        if (rootIdxInOrder < 0) {
            return null;
        }
        // 3、生成头节点
        TreeNode root = new TreeNode(rootVal);

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }

        return root;
    }

    private TreeNode buildTree(int[] preOrder, int preBegin, int preEnd,
                               int[] inOrder, int inBegin, int inEnd) {
        if (preBegin > preEnd || inBegin > inEnd) {
            return null;
        }

        // 1、根节点的值
        int rootVal = preOrder[preBegin];

        // 2、找到该值在中序序列中的索引
        int rootIdxInOrder = -1;
        for (int i=inBegin; i<= inEnd; i++) {
            if (inOrder[i] == rootVal) {
                rootIdxInOrder = i;
                break;
            }
        }
        // 没找到，参数不合法，返回null
        if (rootIdxInOrder < 0) {
            return null;
        }

        // 3、生成头节点
        TreeNode root = new TreeNode(rootVal);

        // 只有一个元素，直接返回，减少递归层次
        if (preBegin == preEnd && inBegin == inEnd) {
            return root;
        }

        // 4、左子树长度
        int leftTreeLen = rootIdxInOrder - inBegin;

        // 5、前序遍历序列中，左子树遍历序列结束索引为preBegin + 1 + leftTreeLen - 1
        int preIdxLeftTreeEnd = preBegin + leftTreeLen;

        // 6、递归处理左右子树，挂接左右节点， 要去掉当前根节点的索引
        root.left = buildTree(preOrder, preBegin+1, preIdxLeftTreeEnd, inOrder, inBegin, rootIdxInOrder-1);
        root.right = buildTree(preOrder, preIdxLeftTreeEnd+1, preEnd, inOrder, rootIdxInOrder+1, inEnd);

        return root;
    }

    public void test(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        TreeNode left = node.left;

        if(left != null){
            test(left);
        }
        TreeNode right = node.right;
        if(right != null){
            test(right);
        }
    }
    public static void main(String[] args) {
        int[] p = {1,2,4,7,3,5,6,8};
        int[] z = {4,7,2,1,5,8,3,6};
        Offer_7 o = new Offer_7();
        TreeNode n = o.reConstructBinaryTree(p,z);

        o.test(n);
    }
}
