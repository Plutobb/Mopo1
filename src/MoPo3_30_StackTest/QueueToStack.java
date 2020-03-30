package MoPo3_30_StackTest;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
    private Queue<Integer> a;
    private Queue<Integer> b;
    /** Initialize your data structure here. */
    public void  MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        a.offer(x);
        while (!b.isEmpty()){
            a.offer(b.poll());
        }
        Queue tmp = a;
        a = b;
        b = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return b.poll();
    }

    /** Get the top element. */
    public int top() {
        return b.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return b.isEmpty();
    }
}
