package MoPo4_10_Sort;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] n = {5,6,3,4,8,7,2,10,1,9};
        System.out.println("冒泡排序");
        allSort.bubbleSort(n);
        allSort.inSort(n);
        allSort.shellSort(n);
        allSort.selectSort(n);
        allSort.heapSort(n);
        allSort.quickSort(n);
        allSort.mergeSort(n);
        System.out.println(Arrays.toString(n));
    }
}
