package MoPo4_10_Sort;

public class allSort {
    public static void swap(int[] array,int a,int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    //冒泡排序法;
    public static void bubbleSort(int[] n){
        for (int i = 0; i < n.length - 1 ; i++) {
            for (int j = 0; j <n.length - i -1 ; j++) {
                if(n[j] > n[j+1]){
                    swap(n,j,j+1);
                }
            }
        }
    }
    //插入排序法;
    public static void inSort(int[] n){
        for (int i = 1; i < n.length; i++) {
            int tmp = n[i];
            int j = i - 1;
            for (; j >= 0 &&n[j] > tmp; j--) {
                n[j+1] = n[j];
            }
            n[j + 1] = tmp;
        }
    }
    //希尔排序;
    public static void shellSort(int[] n){
        int gap = n.length;
        while (gap > 1 ){
            inSortGap(n,gap);
            gap = (gap / 3) + 1;//或者是 gap = gap / 2;最佳gap需要计算;
        }
        inSortGap(n,1);
    }
    public static void  inSortGap(int[] n,int gap){
        for (int i = 1; i < n.length; i++) {
            int tmp = n[i];
            int j = i - gap;
            for (; j >= 0 && n[j] > tmp; j -= gap) {
                n[j + gap] = n[j];
            }
            n[j + gap] = tmp;
        }
    }
    //选择排序;
    public static void  selectSort(int[] n){
        for (int i = 0; i < n.length-1; i++) {
            int max = 0;
            //无序区间[0,n.length-i-1);
            // 有序区间[n.length-i-1,n.length-1);
            for (int j = 1; j < n.length-i; j++) {
                if (n[j] > n[max]){
                    max = j;
                }
            }
            swap(n,max,n.length-1-i);
        }
    }
    //堆排序;
    public static void  heapSort(int[] n){
        //先把数组建堆,升序建大堆,降序建小堆;
        creatHeap(n,n.length);
        for (int i = 0; i < n.length; i++) {
            //每次将堆顶元素与堆尾交换;
            //再进行向下调整;
            swap(n,0,n.length-1-i);
            //无序区间[0,n.length-i-1),有序区间[n.length-i-1,n.length);
            shiftDown(n,n.length-1-i,0);
        }
    }
    public static void creatHeap(int[] n,int size){
        for (int i=(size-1)/2; i >= 0;i--) {
            shiftDown(n,size,i);
        }
    }
    public static void shiftDown(int[] n,int size,int parent){
        int left = parent * 2 +1;
        while (left < size){
            int right = parent * 2 + 2;
            int max = left;
            if(right < size){
                if(n[right] > n[left]){
                    max = right;
                }
            }
            if (n[parent] >= n[max]){
                break;
            }
            swap(n,parent,max);
            parent = max;
            left = max * 2 + 1;
        }
    }
}
