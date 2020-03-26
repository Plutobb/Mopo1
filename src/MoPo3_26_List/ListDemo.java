package MoPo3_26_List;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> courses = new ArrayList<>();
        courses.add("c语言");
        courses.add("java SE");
        courses.add("java Web");
        courses.add("java EE");
        //允许添加重复元素;
        courses.add("c语言");
        //按顺序打印链表;
        System.out.println(courses);
        //移除元素;两种方式:下标和内容
        courses.remove(4);
        System.out.println(courses);
        courses.remove("c语言");
        System.out.println(courses);
        //按照下标访问元素;
        System.out.println(courses.get(0));
        System.out.println(courses);
        //根据下表替换元素;
        courses.set(0,"计算机基础");
        System.out.println(courses);
        //截取链表部分[1,3);
        List<String> subCourses = courses.subList(1,3);
        System.out.println(subCourses);
        //重新构造;
        ArrayList<String> courses2 = new ArrayList<>(courses);
        LinkedList<String> courses3 = new LinkedList<>(courses);
    }
}
