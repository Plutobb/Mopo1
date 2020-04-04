package MoPo4_4_TreeQuesstionC;

import MoPo3_31_Tree.TreeTest;
import java.util.LinkedList;
import java.util.Queue;

public class isCompleteTree {
    public static boolean isCompleteTreeA(TreeTest.TreeNode root) {
        //层序遍历;
        if(root == null){
            return true;
        }
        Queue<TreeTest.TreeNode> queue = new LinkedList<>();// LinkedList做队列的话支持添加null元素，而ArrayDeque不支持添加null
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()){
            int curCount = queue.size();
            for (int i = 0; i <curCount; i++) {
                TreeTest.TreeNode curNode = queue.poll();
                if(curNode != null){
                    if(flag) return false;//说明之前出现过NULL,代表不是完整二叉树
                    queue.add(curNode.left);//层序遍历顺序进行比对;
                    queue.add(curNode.right);
                }else {
                    flag = true;
                }
            }
        }
        return true;
    }
}
