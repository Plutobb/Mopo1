package MoPo4_13_MapSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("i");
        set.add("love");
        set.add("u");
        System.out.println(set);
        //迭代器遍历打印Set;
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(set.iterator().next());
    }
}
