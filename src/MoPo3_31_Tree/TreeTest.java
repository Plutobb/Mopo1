package MoPo3_31_Tree;


public class TreeTest {
    //二叉树节点建立;
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }
    //递归先序遍历二叉树;
    public static void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //递归中序遍历二叉树;
    public static void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }
    //递归后序遍历二叉树;
    public static void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }
    //求出二叉树节点个数;
    public static int getSize(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + getSize(root.right) + getSize(root.left);
    }
    //求出二叉树叶子节点个数;
    public static int getLeafSize(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }
    //求出二叉树第k层节点个数;
    public static int getKNode(TreeNode root, int k){
        if(k < 1 ){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKNode(root.left ,k-1) + getKNode(root.right,k-1);
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;
        System.out.print("先序遍历:");
        preOrderTraversal(a);
        System.out.println();
        System.out.print("中序遍历:");
        inOrderTraversal(a);
        System.out.println();
        System.out.print("后序遍历:");
        postOrderTraversal(a);
        System.out.println();
        System.out.print("总结点个数:");
        System.out.println(getSize(a));
        System.out.print("叶子节点个数:");
        System.out.println(getLeafSize(a));
        System.out.print("第k层节点个数:");
        System.out.println(getKNode(a,3));
    }
}
