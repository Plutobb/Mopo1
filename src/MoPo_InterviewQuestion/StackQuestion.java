package MoPo_InterviewQuestion;

import sun.misc.Queue;

import java.util.HashSet;
import java.util.Stack;

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
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
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
    public static void main(String[] args) {
//        String[] a = {"2","3","+","3","*","3","-"};
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        System.out.println(IsPopOrder(a,b));
//        System.out.println(evalRPN(a));
    }
}
