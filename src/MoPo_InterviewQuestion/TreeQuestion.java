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
        List<List<Integer>> out = levelOrder(a);
        System.out.println(out);

    }
}
