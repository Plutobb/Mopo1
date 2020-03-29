package MoPo3_29_Stack;

import java.util.ArrayList;

public class MyQueue<E> {
    private ArrayList<E> list = new ArrayList<>();
    public MyQueue(){}
    public int size(){
        return list.size();
    }
    public void enQueue(E e){
        list.add(e);
    }
    public E deQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空!");
        }else {
            E e = list.get(0);
            list.remove(0);
            return e;
        }
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
