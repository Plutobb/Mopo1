package MoPo_InterviewQuestion;

import java.util.*;

public class StackQuestion {
    //编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
    //今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
    //例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
    static Stack<Integer> prices,weight;
    public void StockSpanner() {
        prices = new Stack<>();
        weight = new Stack<>();
    }
    public static int next(int price) {
        int w = 1;
        while (!prices.empty() && prices.peek() <= price){
            prices.pop();
            w += weight.pop();
        }
        prices.push(price);
        weight.push(w);
        return w;
    }
    //根据逆波兰表示法，求表达式的值。
    //有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
    public static int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<>();
        for (String c : tokens){
            if (c == "+"){
                num.push(num.pop()+num.pop());
            }else if (c == "-"){
                int b = num.pop();
                num.push(num.pop() - b);
            }else if (c == "*"){
                num.push(num.pop() * num.pop());
            }else if (c == "/"){
                num.push(num.pop()  / num.pop());
            }else {
                num.push(Integer.parseInt(c));
            }
        }
        return num.pop();
    }
    //输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
    // 假设压入栈的所有数字均不相等。
    // 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
    // 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0 || popA.length != pushA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
    //你现在是棒球比赛记录员。
    //给定一个字符串列表，每个字符串可以是以下四种类型之一：
    //1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
    //2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
    //3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
    //4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
    //
    //每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
    //你需要返回你在所有回合中得分的总和。
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        for(String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }
    //给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
    // 判断二者是否相等，并返回结果。 # 代表退格字符。
    //注意：如果对空文本输入退格字符，文本继续为空。
    public static boolean backspaceCompare(String S, String T) {
        //判断是否两个栈相同,艺术的方法;
        return build(S).equals(build(T));
    }
    public static String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
    //有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
    // 第一种为直接收养所有动物中最早进入收容所的，第二种为选择收养的动物类型（猫或狗），
    // 并收养该种动物中最早进入收容所的。
    // 给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。
    // 若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫；
    // 若第一个元素为2，则代表有人收养动物，
    // 第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，若为-1则指定收养猫。
    // 请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
    //测试样例：
    //[[1,1],[1,-1],[2,0],[2,-1]]
    //返回：[1,-1]
    public static ArrayList<Integer> asylum(int[][] ope) {
        ArrayList<Integer> ret = new ArrayList<Integer>();// 存放最终收养序列
        ArrayList<Integer> animal = new ArrayList<Integer>();// 存放进入收容所的动物
        int temp=0;
        for (int i = 0; i < ope.length; i++) {
            switch (ope[i][0]) {
                // 有动物进入收容所
                case 1:
                    animal.add(ope[i][1]);
                    break;
                // 有人收养动物
                case 2:
                    // 第一种收养方式
                    if (!animal.isEmpty()&&ope[i][1] == 0) {
                        ret.add(animal.get(0));
                        animal.remove(0);
                    }
                    // 收养狗
                    else if (ope[i][1] == 1) {
                        for(temp=0;temp<animal.size();temp++){
                            if(animal.get(temp)>0){
                                ret.add(animal.get(temp));
                                animal.remove(temp);
                                break;
                            }
                        }
                    }
                    // 收养猫
                    else if(ope[i][1] == -1){
                        for(temp=0;temp<animal.size();temp++){
                            if(animal.get(temp)<0){
                                ret.add(animal.get(temp));
                                animal.remove(temp);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        return ret;
    }
    //约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。有n个人站成一列。
    // 并从头到尾给他们编号，第一个人编号为1。
    // 然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。
    // 接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。
    // 以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。
    //给定一个int n，代表游戏的人数。请返回最后一个人的编号
    public static int getResult(int n) {
        LinkedList<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        int count = 2;
        while (people.size() > 1){
            for (int i = 0; i < people.size(); i++) {
                int num = i % count + 1;
                if (num != 1){
                    //这里直接删除会导致后面的下标出现错位;
                    people.set(i,0);
                }
            }
            count++;
            //利用迭代器,把值为0的节点删掉;
            people.removeIf(integer -> integer == 0);
            //将最后一个放到链表头;
            people.addFirst(people.getLast());
            people.remove(people.size()-1);

        }
        return people.getFirst();
    }
    public static void main(String[] args) {
//        String[] a = {"2","3","+","3","*","3","-"};
//        int[] a = {1,2,3,4,5};
//        int[] b = {4,5,3,2,1};
//        System.out.println(IsPopOrder(a,b));
//        System.out.println(evalRPN(a));
        System.out.println(getResult(5));
    }
}
