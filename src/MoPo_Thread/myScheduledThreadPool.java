package MoPo_Thread;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

public class myScheduledThreadPool {
    //创建优先队列;
    private PriorityBlockingQueue<myTimerTask> queue = new PriorityBlockingQueue();

    public myScheduledThreadPool(int capacity) {
        myTimer[] thread = new myTimer[capacity];
        for (int i = 0; i < capacity; i++) {
            thread[i] = new myTimer(queue);
            thread[i].start();
        }
    }
    //创建线程;
    private static class myTimer extends Thread{
        private PriorityBlockingQueue<myTimerTask> queue;

        public myTimer(PriorityBlockingQueue<myTimerTask> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            //线程执行任务的过程;
            //这里要特别注意阻塞队列的方法;
            //take 和 put 在队列达到上限和下限的时候会阻塞等待;
            //而 pool 和 offer 在达到上限和下限的时候不会阻塞,而是返回空;
            //这里要使用take 和 put;
            try {
                while (true){
                    //myTimerTask task = queue.poll();
                    myTimerTask task = queue.take();
                    synchronized (queue){
                        long current = System.currentTimeMillis();
                        if (current < task.next){
                            //时间没到,阻塞等待;
                            queue.wait(task.next - current);
                            //因为之前取出来了task,需要再放回去;
                            queue.put(task);
                        }else {
                            task.run();
                            if (task.period > 0){
                                task.next = task.next+task.period;//修改下次执行的时间;
                                queue.put(task);
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //创建定时任务放到优先队列中;
    public void schedule(Runnable runnable,long delay,long period){
        myTimerTask task = new myTimerTask(runnable,new Date().getTime()+delay,period);
        //加锁保证线程安全
        synchronized (queue){
            queue.put(task);
            queue.notifyAll();
        }
    }
    //定时任务;
    private static class myTimerTask implements Runnable,Comparable<myTimerTask>{
        private Runnable runnable;
        private long next;//下次执行时间;
        private long period;//执行时间间隔

        public myTimerTask(Runnable runnable, long next, long period) {
            this.runnable = runnable;
            this.next = next;
            this.period = period;
        }

        @Override
        public void run() {
            runnable.run();
        }

        @Override
        public int compareTo(myTimerTask o) {
            return Long.compare(next,o.next);
        }
    }

    public static void main(String[] args) {
        myScheduledThreadPool pool = new myScheduledThreadPool(4);
        pool.schedule(()->{
            System.out.println("我");
        },0,1000);
        pool.schedule(()->{
            System.out.println("爱");
        },250,1000);
        pool.schedule(()->{
            System.out.println("学");
        },500,1000);
        pool.schedule(()->{
            System.out.println("习");
        },750,1000);
    }
}
