package MoPo_InterviewQuestion;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class oneDayOJ {
    public static Boolean huiWen(String c){
        int i = 0;
        int j = c.length()-1;
        while (i <= j){
            if (c.charAt(i) == c.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
    public static int level(String a,String b){
        int ans = 0;
        String c;
        for (int i = 0; i <= a.length(); i++) {
            Boolean isHuiWen = false;
            String sub1 = a.substring(0,i);
            String sub2 = a.substring(i,a.length());
            c = sub1 + b + sub2;
            isHuiWen = huiWen(c);
            if (isHuiWen){
                ans++;
            }
        }
        return ans;
    }
    //回文字符转判断;
    public static void oj1(){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(level(a,b));
    }
    //----------------------------------------------------------------------------------------------------------
    public static int findKth(int[] a, int n, int K) {
        // write code here
        PriorityQueue<Integer> queue = new PriorityQueue(K);
        for (int i = 0; i < n; i++) {
            if (queue.size() < K){
                queue.add(a[i]);
                continue;
            }
            if (a[i] > queue.peek()){
                queue.poll();
                queue.add(a[i]);
            }
        }
        return queue.peek();
    }
    //寻找第K大
    public static void oj2(){
        int[] a = {1,2,5,3,2};
        System.out.println(findKth(a,5,3));
    }
    // ---------------------------------------------------------------------------------------------------
    //空瓶子换汽水问题；
    public static void waterNum(int n){
        int water = 0;
        int emptyBottle = n;
        int changeBottle = 0;
        //换完不够换的瓶子 < 3；
        int surplusBottle = 0;
        //总共换来的汽水；
        do {
            changeBottle = emptyBottle / 3;
            surplusBottle = emptyBottle % 3;
            water += changeBottle;
            emptyBottle = changeBottle + surplusBottle;
        } while (emptyBottle >= 3);
        if (emptyBottle == 2)
            water++;
        System.out.println(water);

    }
    public static void oj3(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            waterNum(n);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //有一数组任意找两个数如果前面数大于后面则成为逆序对，求出数组逆序对个数；
    public static int count(int[] A, int n) {
        // write code here
        int num = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (A[i] > A[j]){
                    num++;
                }
            }
        }
        return num;
    }
    public static void oj4(){
        int[] a = {1,2,3,4,5,6,7,0};
        System.out.println(count(a,8));
    }
    //---------------------------------------------------------------------------------------------------
    //读入一个字符串str，输出字符串中最长的数子串；
    public static String maxNUmString(String str){
        int begin = 0,end=0,max=0;
        String ret = null;
        Boolean isSameNumString = false;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= '0') && (str.charAt(i) <= '9')){
                if (!isSameNumString) {
                    begin = i;
                    isSameNumString = true;
                }
                if ((i+1) == str.length() || ((str.charAt(i+1) < '0') || (str.charAt(i+1) > '9'))){
                    end = i+1;
                    if (end > begin) {
                        isSameNumString = false;
                        if ((end - begin) > max) {
                            max = end - begin;
                            ret = str.substring(begin, end);
                        }
                    }
                }
            }
        }
        return ret;
    }
    public static void oj5(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(maxNUmString(str));
    }
    //---------------------------------------------------------------------------------------------------
    //给定一个字符串，设计算法判断括号是否合法；
    public static boolean chkParenthesis(String A, int n) {
        int left = 0,right = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') left++;
            else if (A.charAt(i) == ')') right++;
            else return false;
            if (left < right) return false;
        }
        return true;
    }
    public static void oj6(){
        String a = "()a()()";
        System.out.println(chkParenthesis(a,7));
    }
    //---------------------------------------------------------------------------------------------------
    //购买n个水果，使用可以装6个和8个的袋子，必须装满，求最少需要用到的袋子数，如果装不满，返回-1；
    public static int bagMinNum(int n){
        //最多需要8量装的袋子数；
        int max8 = n / 8;
        int need6 = n % 8;
        //当8量装袋子刚好够直接返回；
        if (need6 == 0){
            return max8;
        }else {
            for (int i = max8; i >= 0; i--) {
                need6 = (n - i * 8) / 6;
                if ((n - i * 8) % 6 == 0){
                    return i + need6;
                }
            }
            return -1;
        }
    }
    public static void oj7(){
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(bagMinNum(n));
    }
    //---------------------------------------------------------------------------------------------------
    //给两个字符串，删除第一个中含有第二个字符串中的所有字符；
    public static String deleteChar(String a,String b){
        StringBuilder aBuffer = new StringBuilder(a);
        HashSet<Character> bChar = new HashSet<>();
        for (Character character : b.toCharArray()){
            bChar.add(character);
        }
        for (int i = 0; i < aBuffer.length(); i++) {
            if (bChar.contains(aBuffer.charAt(i))){
                aBuffer.deleteCharAt(i);
                i--;
            }
        }
        return aBuffer.toString();
    }
    public static void oj8(){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(deleteChar(a,b));
    }
    //---------------------------------------------------------------------------------------------------
    public static void oj9(){

    }
    public static void main(String[] args) {

    }
}
