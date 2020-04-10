package MoPo4_10_Sort;

public class bubbleSort {
    public static void bubbleSort(int[] n){
        for (int i = 0; i < n.length - 1 ; i++) {
            for (int j = 0; j <n.length - i -1 ; j++) {
                if(n[j] > n[j+1]){
                    swap.swap(n,j,j+1);
                }
            }
        }
    }
}
