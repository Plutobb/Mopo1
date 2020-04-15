package MoPo4_13_MapSet;

public class TreeMap {
    //二叉搜索树又称二叉排序树，它或者是一棵空树**，或者是具有以下性质的二叉树:
    //若它的左子树不为空，则左子树上所有节点的值都小于根节点的值
    // 若它的右子树不为空，则右子树上所有节点的值都大于根节点的值
    // 它的左右子树也分别为二叉搜索树
    public static class Node{
        int key;
        Node left;
        Node right;
        public Node(int key){
            this.key = key;
        }
    }
    private static Node root = null;
    //搜索操作
    public static Node search(int key){
        Node cur = root;
        while (cur != null){
            if (key == cur.key){
                return cur;
            }else if (key > cur.key){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }
    //插入操作
    public static boolean insert(int key){
        if (root == null){
            root = new Node(key);
            return true;
        }
        Node cur = root;
        Node parent = null;
        while (true){
            if (key == cur.key){
                return false;
            }else if (key < cur.key){
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
            Node node = new Node(key);
            if (key > parent.key){
                parent.right = node;
            }else {
                parent.left = node;
            }
            return true;
        }
    }
    public static void main(String[] args) {

    }
}
