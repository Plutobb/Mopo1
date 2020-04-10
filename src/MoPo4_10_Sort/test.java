package MoPo4_10_Sort;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] n = {5,6,3,4,8,7,2,9,1,10};
        System.out.println("冒泡排序");
        bubbleSort.bubbleSort(n);
        System.out.println(Arrays.toString(n));
    }
}
