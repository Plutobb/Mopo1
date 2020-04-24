package MoPo_InterviewQuestion;

import MoPo4_13_MapSet.TreeMap;

import java.util.ArrayList;
import java.util.List;

public class TreeQuestion {
    public static class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int x){
            val = x;
        }
    }
    //给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
    //递归法;
    static List<List<Integer>> ret = new ArrayList<List<Integer>>();
    public static void helper (TreeNode node, int level){
        //创建一个新一层的链表;每层创建一次当size==level时创建;
        if (ret.size() == level){
            ret.add(new ArrayList<Integer>());
        }
        //将每一层元素放入对应链表
        ret.get(level).add(node.val);
        if (node.left != null){
            helper(node.left,level+1);
        }
        if (node.right != null){
            helper(node.right,level+1);
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return ret;
        }
        helper(root,0);
        return ret;
    }

//    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root ==null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null) {
            return right;
        }
        else if (right == null) {
            return left;
        }else {
            return root;
        }
    }
    //*根据一棵树的前序遍历与中序遍历构造二叉树。
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    private static TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start;
        //递归的构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }
//    你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
//    空节点则用一对空括号 "()" 表示。
//    而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
    public static String tree2str(TreeNode t) {
        if (t == null){
            return "";
        }
        if (t.left == null && t.right == null){
            return t.val + "";
        }
        if (t.right == null){
            return t.val + "("+tree2str(t.left)+")";
        }
        return t.val + "("+tree2str(t.left)+")"+"("+tree2str(t.right)+")";
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(6);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        //层序遍历测试;
//        List<List<Integer>> out = levelOrder(a);
//        System.out.println(out);
        System.out.println(tree2str(a));
    }
}
