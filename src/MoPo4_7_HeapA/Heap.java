package MoPo4_7_HeapA;

public class Heap {
    //堆的向下调整；
    public static void shiftDown(int[] array, int size,int index){
        int left = 2*index+1;
        while (left < size){//说明存在左孩子；
            int min = left;
            int right = 2 * index + 2;
            if (right < size){//将左右子树中较小的下标赋值给min；
                if(array[right] < array[left]){
                    min = right;
                }
            }
            if (array[index] < array[min]){//此时这个节点不需要调整；
                break;
            }
            int tmp = array[index];//否则交换位置；
            array[index] = array[min];
            array[min] = tmp;
            index = min;//交换后的下标为原来的小的子树的下标；
            left = 2 * index + 1;
        }
    }
}
