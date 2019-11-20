package suanfa.ERchashu;

public class BinarySearchTree {
    private Node tree;

    /**
     * 二叉查找树的查询操作
     * @param data
     * @return
     */
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }

    /**
     * 二叉查找树的插入操作
     * @param data
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }


    /**
     * 二叉树删除操作
     * @param data
     */
    public void delete(int data) {
        Node p = tree; // p 指向要删除的节点，初始化指向根节点
        Node pp = null; // pp 记录的是 p 的父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }
        if (p == null) return; // 没有找到

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) { // 查找右子树中最小节点
            Node minP = p.right;
            Node minPP = p; // minPP 表示 minP 的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data; // 将 minP 的数据替换到 p 中
            p = minP; // 下面就变成了删除 minP 了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p 的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) tree = child; // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }

    public static void bianli(Node node){
        if(node == null) return;
        System.out.println(node.data);
        if(node.left != null) bianli(node.left);

        if(node.right != null) bianli(node.right);


    }

    /**
     * @param num
     */
    public void c(int num){
        if(tree == null)return;
        Node p = tree;
        while (p != null){
            if(num < p.data){
                if(p.left == null){
                    p.left = new Node(num);
                    return;
                }
                p = p.left;
            }else if(num > p.data){
                if(p.right == null){
                    p.right = new Node(num);
                    return;
                }
                p = p.right;
            }
        }
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[10];
        for (int i = 0; i < 10; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < 10; i++) {
            if(i*2 + 1 < 10){
                nodes[i].left = nodes[i*2 + 1];
            }
            if(i*2 + 2 < 10){
                nodes[i].right = nodes[i*2 + 2];
            }
        }

        bianli(nodes[0]);
    }
}
