package MoPo_Thread;

public class myBlockQueue <T> {
    //数组实现阻塞队列;
    private Object table[];
    private int takeIndex;
    private int putIndex;
    private int size;
    public myBlockQueue(int capacity) {
        table = new Object[capacity];
    }
    public synchronized void put(T element) throws InterruptedException {
        while (size == table.length)
            //队列满了,后续线程等待;
            wait();
        table[putIndex] = element;
        putIndex = (putIndex + 1) % table.length;
        size++;
        notifyAll();
    }
    public synchronized T take() throws InterruptedException {
        while (size == 0)
            wait();
        Object element = table[takeIndex];
        takeIndex = (takeIndex + 1) % table.length;
        size--;
        notifyAll();
        return (T) element;
    }
    public synchronized int size(){
        return size;
    }
    public static void main(String[] args) throws InterruptedException {
        myBlockQueue queue = new myBlockQueue(10);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                while (true) {
                    synchronized (queue) {
                        try {
                            queue.put(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //当获取size时需要加锁,保证原子性;
                        System.out.println("生产一个面包"+queue.size());
                    }
                }
            }).start();
        }
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                while (true) {
                    synchronized (queue) {
                        try {
                            queue.take();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("消费一个面包"+queue.size());
                    }
                }
            }).start();
        }
    }
}
