package MoPo4_3_TreeQuestionB;

import MoPo3_31_Tree.TreeTest;

public class CreatTree {
    public static TreeTest.TreeNode creatTree(){
        TreeTest.TreeNode a = new TreeTest.TreeNode('A');
        TreeTest.TreeNode b = new TreeTest.TreeNode('B');
        TreeTest.TreeNode c = new TreeTest.TreeNode('C');
        TreeTest.TreeNode d = new TreeTest.TreeNode('D');
        TreeTest.TreeNode e = new TreeTest.TreeNode('E');
        TreeTest.TreeNode f = new TreeTest.TreeNode('F');
        TreeTest.TreeNode g = new TreeTest.TreeNode('G');
        TreeTest.TreeNode h = new TreeTest.TreeNode('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;
        return a;
    }
}
