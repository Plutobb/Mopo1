package MoPo4_2_TreeQuestion;

import MoPo3_31_Tree.TreeTest;

public class TreeQuestion {
    public static boolean isSameTree(TreeTest.TreeNode p, TreeTest.TreeNode q){
        // 可以分成四种情况:
        // 1. p q 都为 null
        // 2. p 为 null, q 不为 null
        // 3. p 不为 null, q 为 null
        // 4. p q 都不为 null
        if (p == null && q == null) {
            // 两个树都是空树. 认为是相同的
            return true;
        }
        // if ((p == null && q != null) || (p != null && q == null)) {
        // 由于上面的逻辑, p 和 q 不会同时为 null. 只有说一个为 null 一个非 null 才能进入条件内部
        if (p == null || q == null) {
            // p 和 q 只有一个为 null 另一个不为 null
            return false;
        }
        // 下面的逻辑就是处理都不为 null 的情况了
        // 先判断根节点是否相同
        if (p.val != q.val) {
            // 这两棵树一定不相等
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
