package MoPo3_29_StackAndQueue;

public class TestQueue {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enQueue(0);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.isEmpty());
    }
}
