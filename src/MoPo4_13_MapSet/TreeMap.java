package MoPo4_13_MapSet;

import java.util.function.BinaryOperator;

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
        while (cur != null){
            if (key == cur.key){
                return false;
            }else if (key < cur.key){
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        Node node = new Node(key);
        if (key > parent.key){
            parent.right = node;
        }else {
            parent.left = node;
        }
        return true;
    }
    public static boolean remove(int key){
        Node cur = root;
        Node parent = null;
        while (cur != null){
            if (key == cur.key){
                removeNode(parent,cur);
                return true;
            }else if (key > cur.key){
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
        return false;
    }
    public static void removeNode(Node parent , Node cur){
        if (cur.left == null){
            if (cur == root){
                root = cur.right;
            }else if (cur == parent.left){
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if (cur.right == null){
            if (cur == root){
                root =cur.left;
            }else if (cur == parent.left){
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            Node goatParent = cur;
            Node goat = cur.right;
            while (goat.left != null){
                goatParent =goat;
                goat = goat.left;
            }
            cur.key = goat.key;
            if (goat == goatParent.left){
                goatParent.left = goat.right;
            }else {
                goatParent.right = goat.right;
            }
        }
    }
    public static void inOrder(Node root){
        if (root != null){
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }
    public static void main(String[] args) {
        TreeMap tree = new TreeMap();
        int[] keys = {3,9,7,4,1,6,2,8,5};
        for (int key : keys){
            System.out.println(tree.insert(key));
        }
        tree.remove(5);
        inOrder(tree.root);
    }
}
