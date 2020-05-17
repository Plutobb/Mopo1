package MoPo_Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class myThread {
    //多线程;
    public static void firstBlood() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一滴血");
            }
        },"第一滴血").start();
        System.out.println("main");
    }
    //多线程可以增加运行速度;
    //对比串行和并行;
    public static final long count = 1000000000;
    //并发计算ab;
    public static void concurrency() throws InterruptedException {
        long begin = System.nanoTime();
        //创建一个子线程来计算a的值;
        Thread thread = new  Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a++;
                }
            }
        });
        thread.start();
        //主线程中计算b的值;
        int b = 0;
        for (int i = 0; i < count; i++) {
            b++;
        }
        //等待thread进程结束,计算用时;
        thread.join();
        long end = System.nanoTime();
        double ms = (end - begin) * 1.0 / 10000 / 10000;
        System.out.printf("并发:用时%f毫秒\n",ms);
    }
    //串行计算ab;
    public static void  serial(){
        int a = 0 , b = 0;
        long begin = System.nanoTime();
        for (int i = 0; i < count; i++) {
            a++;
        }
        for (int i = 0; i < count; i++) {
            b++;
        }
        long end = System.nanoTime();
        double ms = (end - begin) * 1.0 /10000/10000;
        System.out.printf("串行:用时%f毫秒",ms);
    }
    public static void threadJoin() throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            final int j = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                }
            });
            t.start();
            threads[i] = t;
        }
        for (int i = 0; i < 20; i++) {
            threads[i].join();
        }
    }
    public static void threadInterrupted() throws InterruptedException {
            AtomicInteger i = new AtomicInteger();
            Thread t = new Thread(()->{
                try {
                    while (!Thread.interrupted()){
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    //这里抛出异常后会重置Interrupt为false;
                    e.printStackTrace();
                }
            });
            t.start();
            Thread.sleep(3000);
            t.interrupt();
    }
    public static void printInterrupted(){
        Thread thread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        thread.start();
        thread.interrupt();
    }
    public static void main(String[] args) throws InterruptedException {
        //比较速度;
//        concurrency();
//        serial();
        //线程等待;
//        threadJoin();
//        System.out.println("main");
        //threadInterrupted();
       // printInterrupted();
    }
}
