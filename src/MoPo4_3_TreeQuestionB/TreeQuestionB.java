package MoPo4_3_TreeQuestionB;

import MoPo3_31_Tree.TreeTest;

public class TreeQuestionB {
    private static int index = 0;
    public static TreeTest.TreeNode buildTreeHelper(int[] preOrder,int[] inOrder,int left,int right){
        if(left >= right){
            return null;
        }
        if(index >= preOrder.length){
            return null;
        }
        TreeTest.TreeNode root = new TreeTest.TreeNode(preOrder[index]);
        int pos = toFind(inOrder,preOrder[index]);
        index++;
        root.left = buildTreeHelper(preOrder,inOrder,left,pos);
        root.right = buildTreeHelper(preOrder, inOrder, pos+1, right);
        return root;
    }
    public static int toFind(int[] inOrder,int index){
        for (int i = 0; i <inOrder.length; i++) {
            if(inOrder[i] == index){
                return i;
            }
        }
        return -1;
    }
}
