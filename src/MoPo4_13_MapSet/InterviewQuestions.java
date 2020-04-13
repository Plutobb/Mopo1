package MoPo4_13_MapSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InterviewQuestions {
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
}
