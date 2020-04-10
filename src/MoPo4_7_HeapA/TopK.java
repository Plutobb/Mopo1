package MoPo4_7_HeapA;

import java.util.Arrays;

public class TopK {
    //在N个数中找到K个最大的数;
    //先将前K个数建立一个小根堆;
    //依次将剩余的数一个个进行比较,若大于根则替换在向下调整,否则就下一个数;
    //最后堆中元素就是前K个最大的数;
    public static void swap(int[] array,int a,int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    public static void shiftDown(int[] array,int index){
        int left = index * 2 +1;
        while (left < array.length){
            int min = left;
            int right = index * 2 + 2;
            if (right < array.length){
                if (array[left] > array[right]){
                    min = right;
                }
            }
            if (array[index] < array[min]){
                break;
            }
            swap(array,index,min);
            index = min;
            left = index * 2 + 1;
        }
    }
    public static void creatHeapK(int[] array){
        for (int i =(array.length - 1) / 2; i >= 0 ; i--) {
            shiftDown(array,i);
        }
    }
    public static int[] topK(int[] n,int k){
        int[] topK = new int[k];
        System.arraycopy(n, 0, topK, 0, k);
        creatHeapK(topK);
        for (int i = k; i <n.length; i++) {
            if (n[i] > topK[0]){
                topK[0] = n[i];
                shiftDown(topK,0);
            }
        }
        return topK;
    }
    public static void main(String[] args) {
        int[] n = {1,3,9,4,6,8,2,5,7,10};
        System.out.println(Arrays.toString(topK(n,3)));
    }
}
