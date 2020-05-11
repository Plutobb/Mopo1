package MoPo_InterviewQuestion;

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

    public static void main(String[] args) {
        String[] a = {"2","3","+","3","*","3","-"};
        System.out.println(evalRPN(a));
    }
}
