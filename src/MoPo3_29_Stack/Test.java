package MoPo3_29_Stack;

import java.util.ArrayList;
import java.util.SplittableRandom;
import java.util.Stack;

public class Test{
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
