package MoPo4_13_MapSet;

public class HashMap {
    static class Node{
        public int key;
        public int value;
        public Node next;
        public Node (int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    //负载因子;
    private static final double LOAD_FACTOR = 0.75;
    //array数组就是哈希表的本体,数组每个元素又是链表的头结点;
    private Node[] array = new Node[101];
    private int size = 0;
    private int hashFunc(int key){
        //这里是简化版的求下标,实际的计算下标比较复杂;
        return key % array.length;
    }
    //如果存在value 就修改;
    //不存在就插入;
    public void put(int key,int value){
        int index = hashFunc(key);
        //根据下标找到对应的链表;
        Node list = array[index];
        for (Node cur = list; cur != null; cur=cur.next){
            if (cur.value == value){
                cur.value = value;
                return;
            }
        }
        //循环完毕没有找到直接插入;
        //头插法,尾插法都可以;
        Node newNode = new Node(key, value);
        newNode.next = list;
        array[index] = newNode;
        size++;
        //当元素过多,负载因子过大时需要扩容;
        if (size / array.length > LOAD_FACTOR){
            resize();
        }
    }
    public void resize(){
        Node[] newArray = new Node[array.length*2];
        //将元素放到新的哈希表中;
        for (int i = 0; i < array.length; i++) {
            for (Node cur = array[i]; cur != null; cur = cur.next){
                int index = cur.key % newArray.length;
                Node newNode = new Node(cur.key,cur.value);
                newNode.next = newArray[index];
                newArray[index]  =newNode;
            }
        }
        array = newArray;
    }
    //根据key找到对应的value,找到返回value,否则返回null;
    public Integer get(int key){
        int index = hashFunc(key);
        Node list = array[index];
        for (Node cur = list; cur != null; cur = cur.next){
            if (cur.key == key){
                return cur.value;
            }
        }
        return null;
    }
}
