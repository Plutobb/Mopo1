package MoPo3_29_StackAndQueue;

import java.util.ArrayList;

public class MyStack<E>{//泛型E
    private ArrayList<E> myList = new ArrayList<>();
    //MyStack:创建一个stack;
    //public MyStack(){}
    //size:得到stack的长度;
    public int size(){
        return myList.size();
    }
    //push:将 x 放入 stack 中;
    public void push(E x){
        myList.add(x);
    }
    //pop:将 stack 最后一个元素返回取出;
    public E pop(){
        E e = myList.get(size()-1);
        myList.remove(size()-1);
        return e;
    }
    //peek:得到最后一个元素的值;
    public E peek(){
        return myList.get(size()-1);
    }
    //isEmpty:判断是否为空;
    public boolean isEmpty(){
        return myList.isEmpty();
    }
}
