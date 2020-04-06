package MoPo4_6_TreeTraverse;

import MoPo3_31_Tree.TreeTest;
import MoPo4_3_TreeQuestionB.CreatTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class UnRecursion {
    //非递归先序遍历二叉树;
    public static List<Integer> preOrderTraversal(TreeTest.TreeNode root){
        //建立一个栈来暂时存放二叉树节点;
        LinkedList<TreeTest.TreeNode> stack = new LinkedList<>();
        //建立一个链表来存放遍历结果;
        LinkedList<Integer> outPut = new LinkedList<>();
        if (root == null){
            return outPut;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            //出栈出链表的最后一个元素放入输出链表中;
            TreeTest.TreeNode node = stack.pollLast();
            outPut.add(node.val);
            //因为是先入后出,所以入栈顺序是右子树优先;
            if (node.right != null){
                stack.add(node.right);
            }
            if (node.left != null){
                stack.add(node.left);
            }
        }
        return outPut;
    }
    public static List<Integer> inOderTraversal(TreeTest.TreeNode root){
        List<Integer> ret = new ArrayList<>();
        Stack<TreeTest.TreeNode> stack = new Stack<>();
        TreeTest.TreeNode cur = root;
        while (cur != null || !stack.empty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ret.add(cur.val);
            cur = cur.right;
        }
        return ret;
    }
    public static List<Integer> postOrderTraversal(TreeTest.TreeNode root){
        //宽度搜索,结果逆序输出就得到后序遍历的结果;
        LinkedList<Integer> output = new LinkedList<>();
        LinkedList<TreeTest.TreeNode> stack = new LinkedList<>();
        if(root == null){
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeTest.TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null){
                stack.add(node.left);
            }
            if (node.right != null){
                stack.add(node.right);
            }
        }
        return output;
    }
    public static void main(String[] args) {
        //创建二叉树一棵树;
        TreeTest.TreeNode a = CreatTree.creatTree();
        System.out.println(preOrderTraversal(a));
        System.out.println(inOderTraversal(a));
        System.out.println(postOrderTraversal(a));
    }
}
