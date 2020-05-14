package MoPo_Thread;

public class myThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一滴血");
            }
        },"第一滴血").start();
        System.out.println("main");
    }
}
