package MoPo4_7_HeapA;

import java.util.PriorityQueue;

public class Heap {
    public static class myPriorityQueue{
        public int[] array = new int[100];
        public int size = 0;
        public void offer(int x){
            array[size++] = x;
            shiftUp(array,size-1);//child必须为下标而不能是长度;
        }
        public int poll(){
            int oldValue = array[0];
            array[0] = array[--size];//size是数组长度,先--得到最后一个元素的下标;
            shiftDown(array,size,0);
            return oldValue;
        }
        public int peek(){
            return array[0];
        }
        public void printQueue(){
            for (int i = 0; i <size; i++) {
                System.out.print(array[i]);
            }
        }
    }
    public static void swap(int[] array,int a, int b){
        int tmp = array[a];//否则交换位置；
        array[a] = array[b];
        array[b] = tmp;
    }
    //堆的向下调整；
    public static void shiftDown(int[] array, int size, int index){
        int left = 2*index+1;
        while (left < size){//说明存在左孩子；
            int min = left;
            int right = 2 * index + 2;
            if (right < size){//将左右子树中较小的下标赋值给min；
                if(array[right] < array[left]){
                    min = right;
                }
            }
            if (array[index] <= array[min]){//此时这个节点不需要调整；
                break;
            }
            swap(array,index,min);
            index = min;//交换后的下标为原来的小的子树的下标；
            left = 2 * index + 1;
        }
    }
    public static void shiftUp(int[] array,int child){
        //对入队列元素进行向上调整;
        while (child > 0){
            int parent = (child - 1) / 2;
            if(array[child] > array[parent]){
                swap(array,child,parent);
            }else {
                break;
            }
            child = parent;
        }
    }
    public static void creatHeap(int[] array, int size){
        for (int i = (size-1)/2; i >= 0 ; i--) {
            shiftDown(array,size,i);
        }
    }
    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        int[] intHeap = {8,7,6,1,5,3};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(8);
        queue.offer(7);
        queue.offer(6);
        queue.offer(1);
        queue.offer(5);
        queue.offer(3);
        queue.poll();
        System.out.println(queue);
        myPriorityQueue que = new myPriorityQueue();
        que.offer(1);
        que.offer(5);
        que.offer(3);
        que.offer(8);
        que.offer(7);
        que.offer(6);
        que.printQueue();
        System.out.println();
    }
}
