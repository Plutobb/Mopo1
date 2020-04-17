package MoPo_InterviewQuestion;

import java.util.PriorityQueue;

public class QueueQuestions {
//    有一堆石头，每块石头的重量都是正整数。
//
//    每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//
//    如果 x == y，那么两块石头都会被完全粉碎；
//    如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
//    最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
    public static int lastStoneWeight(int[] stones) {
        int len = stones.length;
        //实现升序;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len,((o1, o2) -> -o1+o2));
        for(int i : stones){
            maxHeap.add(i);
        }
        while (maxHeap.size() >= 2){
            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();
            maxHeap.offer(max1-max2);
        }
        return maxHeap.poll();
    }

    public static void main(String[] args) {

    }
}
