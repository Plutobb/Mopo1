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
    //快速排序;
    public static void quickSort(int[] n){
        quickSortInternal(n,0,n.length-1);
    }
    public static void quickSortInternal(int[] n,int left ,int right){
        if (left >= right){
            return;
        }
        int pivotIndex = partition(n,left,right);
        //递归排序基准左侧;
        quickSortInternal(n,left,pivotIndex-1);
        //递归排序基准右侧;
        quickSortInternal(n,pivotIndex+1,right);
    }
    public static int  partition(int[] n,int left,int right){
        int i = left;
        int j = right;
        int pivot = n[left];//将第一个作为基准;
        while (i < j){
            //从区间两侧开始
            //右侧找到比基准小的值;
            while (i < j && n[j] >= pivot){
                j--;
            }
            //左侧找到比基准大的值;
            while (i < j && n[i] <= pivot){
                i++;
            }
            //将两个值进行交换;
            swap(n,i,j);
        }
        //最后将基准与左侧区间(比基准小的数)中最后一个元素交换;
        //此时基准左侧数值都比基准小,右侧都比基准大;
        swap(n,i,left);
        //返回基准下标;
        return i;
    }
    //归并排序;
    public static void mergeSort(int[] n){
        mergeSortInternal(n,0,n.length);
    }
    public static void mergeSortInternal(int[] n,int low,int high){
        if (low >= high-1){
            return;
        }
        int mid = (low + high) / 2;
        mergeSortInternal(n,low,mid);
        mergeSortInternal(n,mid,high);
        merge(n,low,mid,high);
    }
    public static void  merge(int[] n,int low,int mid,int high){
        int i = low;
        int j = mid;
        int length = (high - low);
        int[] extra = new int[length];
        int k = 0;
        while (i < mid && j < high){
            if (n[i] <= n[j]){
                extra[k++] = n[i++];
            }else {
                extra[k++] = n[j++];
            }
        }
        //当一半组元素先被放入排序数组后,将剩下的元素直接放入排序数组中;
        while (i < mid){
            extra[k++] = n[i++];
        }
        while (j < high){
            extra[k++] = n[j++];
        }
        //再将排序后的extra转移到原来的数组n中;
        for (int t = 0; t < extra.length; t++) {
            n[low + t] = extra[t];
        }
    }
}
