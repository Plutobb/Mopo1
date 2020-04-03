package MoPo4_3_TreeQuestionB;

import MoPo3_31_Tree.TreeTest;

public class TreeToString {
    public static String treeToString(TreeTest.TreeNode root){
        if(root == null){
            return "";
        }
        if(root.left == null && root.right == null){
            return root.val+"";
        }
        if(root.right == null){
            return root.val+"("+treeToString(root.left)+")";
        }
        return root.val+"("+treeToString(root.left)+")"+"("+treeToString(root.right)+")";
    }

    public static void main(String[] args) {
        TreeTest.TreeNode root = CreatTree.creatTree();
        System.out.println(treeToString(root));
    }
}
