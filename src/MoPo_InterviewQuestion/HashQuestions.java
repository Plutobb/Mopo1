package MoPo_InterviewQuestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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
}
