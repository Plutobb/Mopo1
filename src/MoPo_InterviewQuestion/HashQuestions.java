package MoPo_InterviewQuestion;

import java.util.HashMap;
import java.util.HashSet;

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
}
