package MoPo_Thread;

public class ThreadSafety {
    private static int sum;
    public static void unSafetyThread(){
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    sum++;
                }
            }).start();
        }
        while (Thread.activeCount() > 2){
            //线程让步,运行态转变为就绪态;
            Thread.yield();
        }
        System.out.println(sum);
    }
    //1.关键字synchronized;
    public static synchronized void increment(){
        sum++;
    }
    public static  void thread_1 (){
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    increment();
                }
            }).start();
        }
        while (Thread.activeCount() > 2){
            //线程让步,运行态转变为就绪态;
            Thread.yield();
        }
        System.out.println(sum);
    }
    //简单地实现一个售票方法;
    static class ticketThread implements Runnable {
        private int numTickets = 1000;

        @Override
        public void run() {
            //for (int i = 0; i < 100; i++) {
                synchronized (this){
                    while (this.numTickets > 0){
                        try{
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"还有"+this.numTickets--+"张票");
                    }
                }
           // }
        }
    }
    public static void saleTickets(){
        ticketThread ticketThread = new ticketThread();
        Thread t1 = new Thread(ticketThread,"黄牛A");
        Thread t2 = new Thread(ticketThread,"黄牛B");
        Thread t3 = new Thread(ticketThread,"黄牛C");
        t1.start();
        t2.start();
        t3.start();
    }
    //volatile关键字;
     static class RunThread implements Runnable {
        private volatile boolean isRunning = true;

        public boolean isRunning() {
            return isRunning();
        }
        public void setIsRunning(Boolean isRunning){
            this.isRunning = isRunning;
        }
        @Override
        public void run() {
            int i = 0;
            System.out.println("进入run");
            while (isRunning){
                i++;
            }
            System.out.println(i);
            System.out.println("退出run");
        }
    }
    //双重校验锁的单例模式;
    //性能高.
    static class Singleton{
        private  Singleton(){};
        //volatile关键字保证可见性;
        private static volatile Singleton instance = null;
        public static Singleton getInstance(){
            //第一层不加锁,有利于第二批次进入的线程直接判断;
            if (instance == null){
                //第一批线程可能并发进入到下面代码;
                synchronized (Singleton.class){
                    //加锁保证线程安全;
                    if (instance == null){
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //这里sum输出的值跟预想的不符合,涉及到了线程安全问题;
        //unSafetyThread();
        //使用synchronized对方法上锁;
        //thread_1();
        //saleTickets();
//        RunThread thread = new RunThread();
//        Thread t1 = new Thread(thread);
//        t1.start();
//        Thread.sleep(1);
//        thread.setIsRunning(false);
//        System.out.println("结束程序");
    }
}
