package MoPo4_13_MapSet;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

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
    //题目3
    //  旧键盘
    //  题目描述
    //  旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的
    //  一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。
    //  输入描述:
    //  输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，
    //  由字母A-Z（包括大、小写）、数字0-9、以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
    //  输出描述:
    //  按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
    //  输入例子:
    //  7_This_is_a_test
    //  _hs_s_a_es
    //  输出例子:
    //  7TI
    public static void OldKeyboard(){
        Scanner sc = new Scanner(System.in);
        String should = sc.next();
        String old = sc.next();
        Set<Character> set = new HashSet<>();
        should=should.toUpperCase();
        old=old.toUpperCase();
        char[] first = should.toCharArray();
        char[] second = old.toCharArray();
        for (char i : first){
            set.add(i);
        }
        for (char j : second){
            set.remove(j);
        }
        Iterator<Character> it = set.iterator();
        while (it.hasNext()){
            System.out.print(it.next());
        }
    }
    //    给一非空的单词列表，返回前 k 个出现次数最多的单词。
    //
    //    返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        //遍历数组,记录下来每个单词出现的次数存放在value中;
        for (String s : words){
            Integer count = map.getOrDefault(s,0);
            //getOrDefault方法是如果key对应的有value 就取出来,没有的话就用默认的defaultValue;
            map.put(s,count+1);
        }
        //将得到的map.key放入到链表中;
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        //然后对链表中的单词按出现次数排序;
        //但是list自带的sort 默认是按照元素的自身大小进行升序排序(String 的字典序);
        Collections.sort(arrayList, (o1, o2) -> {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2){
                return o1.compareTo(o2);
            }
            return count2 - count1;
        });
        return arrayList.subList(0,k);
    }
}
