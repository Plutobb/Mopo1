package MoPo_InterviewQuestion;

import java.lang.reflect.Array;
import java.util.*;

public class HashQuestions {
    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0,ans = 0,j = 0;
        int n = s.length();
        while (i < n && j < n){
            //当字符不存在的时候,插入到set中;
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                //将set最大长度存放在ans中;
                ans = Math.max(ans,j - i);
            }else {
                //当字符存在就删除set头部位置的一个字符;
                //当删除后还存在就继续删除,直到不存在;
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    //找出数组中重复的数字。
    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                return nums[i];
            }
        }
        return -1;
    }
//    所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
//
//    编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        List<String> list = new LinkedList<>();
        int i = 0, j = 10;
        while (j <= s.length()){
            String str = s.substring(i++,j++);
            if (!set.contains(str)){
                set.add(str);
            }else {
                if (list.isEmpty()){
                    list.add(str);
                }else {
                    int same = 0;
                    for (String value : list) {
                        if (str.equals(value)) {
                            same = 1;
                            break;
                        }
                    }
                    if (same == 0){
                        list.add(str);
                    }
                }
            }
        }
        return list;
    }
    //我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；
    // 该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] output = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            int count = 0;
            for (int j=0; j<words.length; j++) {
                if (funF(queries[i]) < funF(words[j])) {
                    count++;
                }
            }
            output[i] = count;
        }
        return output;
    }
    public int funF(String str) {
        int[] arr = new int[26];
        for (int i=0; i<str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != 0) {
                return arr[i];
            }
        }
        return 0;
    }
    //判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    //
    //数字 1-9 在每一行只能出现一次。
    //数字 1-9 在每一列只能出现一次。
    //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Integer>[] row = new HashMap[9];
        HashMap<Integer,Integer>[] col = new HashMap[9];
        HashMap<Integer,Integer>[] box = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<Integer, Integer>();
            col[i] = new HashMap<Integer, Integer>();
            box[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.'){
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;//求出在3*3的方块中的位置(第几块中)
                    //将数字放入对应的行,列,矩阵,对应的哈希表中;
                    row[i].put(n,row[i].getOrDefault(n,0)+1);
                    col[j].put(n,col[j].getOrDefault(n,0)+1);
                    box[box_index].put(n,box[box_index].getOrDefault(n,0)+1);
                    //判断是否存在出现两次的情况;
                    if (row[i].get(n) > 1 || col[j].get(n) > 1|| box[box_index].get(n) > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //给定两个字符串 s 和 t，它们只包含小写字母。
    //字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
    //请找出在 t 中被添加的字母。
    public static char findTheDifference(String s, String t) {
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            sMap.put(a,sMap.getOrDefault(a,0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char b = t.charAt(i);
            tMap.put(b,tMap.getOrDefault(b,0)+1);
        }
        //sMap 长度等于 tMap 时说明加的字母以前出现过;
        //不相等 说明是新出现的字母;
        if (sMap.size() == tMap.size()){
            for (Character a : sMap.keySet()){
                if (!sMap.get(a).equals(tMap.get(a))){
                    return a;
                }
            }
        }else {
            for (Character b : tMap.keySet()){
                if (!sMap.containsKey(b)){
                    return b;
                }
            }
        }
        return ' ';
    }
    //给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j
    // 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
    //给定一个整数数组，判断是否存在重复元素。
    //如果任意一值在数组中出现至少两次，函数返回 true。
    // 如果数组中每个元素都不相同，则返回 false 。
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return true;
            }
        }
        return false;
    }
    //给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
    //题目保证至少有一个词不在禁用列表中，而且答案唯一。
    //禁用列表中的单词用小写字母表示，不含标点符号。
    // 段落中的单词不区分大小写。答案都是小写字母。

    public static String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        //加入" "避免出现.后跟空字符的情况;
        set.add("");
        paragraph = paragraph.toLowerCase();
        paragraph += '.';
        //结果单词
        String ans = "";
        //记录出现的最大次数
        int maxTime = 0;
        int i = 0;
        for (int j = 0; j < paragraph.length(); j++) {
            char c = paragraph.charAt(j);
            if (c >= 'a' &&  c <= 'z'){
                continue;
            }else {
                String word = paragraph.substring(i,j);
                if (!set.contains(word)){
                    map.put(word,map.getOrDefault(word,0)+1);
                    if (map.get(word) > maxTime){
                        maxTime = map.get(word);
                        ans = word;
                    }
                }
            }
            i = j + 1;
        }
        return ans;
    }
    //给定两个字符串 s 和 t，判断它们是否是同构的。
    //如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
    //所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
    // 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
    public static boolean isIsomorphic(String s, String t) {
        //同构要,满足映射关系,因此s->t且t->s时就代表同构;
        return isIsomorphicHelper(s,t)&&isIsomorphicHelper(t,s);
    }
    public static boolean isIsomorphicHelper(String s,String t){
        HashMap<Character,Character> map  = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)){
                if (map.get(c1) != c2){
                    return false;
                }
            }else {
                map.put(c1,c2);
            }
        }
        return true;
    }
    //给定两个数组，编写一个函数来计算它们的交集。
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }
        int index = 0;
        for(int num : map1.keySet()){
            if (map2.containsKey(num)){
                int time = Math.min(map1.get(num),map2.get(num))+index;
                for (; index < time; index++) {
                    ans[index] = num;
                }
            }
        }
        return Arrays.copyOfRange(ans,0,index);
    }
    //给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                map.remove(s.charAt(i));
                set.add(s.charAt(i));
            }else {
                if (!set.contains(s.charAt(i))) {
                    map.put(s.charAt(i), i);
                }
            }
        }
        if (map.isEmpty()){
            return -1;
        }else {
            int index = s.length();
            for (char c : map.keySet()) {
                index = Math.min(index, map.get(c));
            }
            return index;
        }
    }
    //给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
    //比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。
    // 那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，
    // 员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，
    // 但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
    //现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public static int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for (Employee emp : employees){
            map.put(emp.id,emp);
        }
        return getImp(map,id);
    }
    public static int getImp(HashMap<Integer,Employee> map,int id){
        Employee employee = map.get(id);
        int ret = employee.importance;
        for (int i = 0; i < employee.subordinates.size(); i++) {
            int subId = employee.subordinates.get(i);
            ret += getImp(map,subId);
        }
        return ret;
    }
    public static void main(String[] args) {
        String a = "ddc";
//        String b = "abc";
        int[] x = {1,2,2,4};
        int[] y = {1,2,2};
//        System.out.println(findTheDifference(a,b));
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] ban ={"hit"};
//        System.out.println(mostCommonWord(paragraph,ban));
//        System.out.println(isIsomorphic(a,b));
        //System.out.println(Arrays.toString(intersect(x, y)));
        System.out.println(firstUniqChar(a));
    }
}
