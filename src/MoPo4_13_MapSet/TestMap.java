package MoPo4_13_MapSet;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"o");
        map.put(1,"i");
        //重复key只会按最后一个value;
        map.put(2,"love");
        map.put(3,"u");
        System.out.println(map);
        //根据key返回value;
        System.out.println(map.get(1));
        //查找不到返回null;
        System.out.println(map.get(99));
        //遍历打印key
        for (Integer key : map.keySet()){
            System.out.println(key);
        }
        //遍历打印value
        for (String value : map.values()){
            System.out.println(value);
        }
        //遍历打印key-value;
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
