package MoPo3_30_StackTest;

import MoPo3_29_Stack.MyStack;

import java.util.Stack;

public class Test {
    public static boolean isValid (String s){//括号匹配问题;
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for (char value : c) {
            if (value == '(') {//把左括号对应的右括号压到stack中;
                stack.push(')');
            }else if (value == '{'){
                stack.push('}');
            }else if (value == '['){
                stack.push(']');
            } else if(stack.empty()|| value != stack.pop()){
                return false;
            }
        }
        return stack.empty();
    }
    public static void main(String[] args) {
//        String s = "{{}}";
//        System.out.println(isValid(s));
        QueueToStack queue = new QueueToStack();
        queue.MyStack();
        queue.push(0);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        System.out.println(queue.top());
        System.out.println(queue.empty());
        System.out.println(queue.pop());
    }
}
