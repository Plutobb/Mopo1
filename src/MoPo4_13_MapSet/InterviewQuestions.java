package MoPo4_13_MapSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InterviewQuestions {
    //题目1
    //只出现一次的数字;
    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    public static int singleNumber(int[] nums) {
        Map<Integer,Object> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)){
                map.put(i,null);
            }else {
                map.remove(i);
            }
        }
        return map.keySet().iterator().next();
    }
    //题目2
    //    给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
    //
    //    要求返回这个链表的 深拷贝。 
    //
    //    我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
    //
    //    val：一个表示 Node.val 的整数。
    //    random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
    static class  Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        //第一次循环将所有新节点与老节点一一对应;
        for (Node cur = head; cur != null;cur = cur.next ){
            map.put(cur,new Node(cur.val));
        }
        //第二次循环更新新节点的next和random节点;
        //注意这里新节点指向的next和random是新节点的节点,而不是老节点的节点!
        for (Node cur = head; cur != null; cur = cur.next){
            Node newNode = map.get(cur);
            //map.get(cur.next) 得到的是老节点(cur的next)作为<Key>对应作为<value>的新节点;
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
        }
        return map.get(head);
    }
    //题目3
    //     给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
    //
    //    J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
    public static int numJewelsInStones(String J, String S) {
        Set<Character> jSet = new HashSet<>();
        for (char j : J.toCharArray()){
            jSet.add(j);
        }
        int ans = 0;
        for (char s : S.toCharArray()){
            if (jSet.contains(s)){
                ans++;
            }
        }
        return ans;
    }
}
