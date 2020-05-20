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
    public static void main(String[] args) {
        //这里sum输出的值跟预想的不符合,涉及到了线程安全问题;
        //unSafetyThread();
        //使用synchronized对方法上锁;
        //thread_1();
        saleTickets();
    }
}
