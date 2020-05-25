package MoPo_Thread;

import java.time.chrono.MinguoDate;

public class ThreadQuestion {
    public static void printABC() {
        Thread t1 = new Thread(new print("A",null));
        Thread t2 = new Thread(new print("B",t1));
        Thread t3 = new Thread(new print("C",t2));
        t1.start();
        t2.start();
        t3.start();
    }
    public static class print implements Runnable {
        private String content;
        private Thread t;

        public print(String content,Thread t) {
            this.content = content;
            this.t = t;
        }

        @Override
        public void run() {
            if (t == null) {
                System.out.println(content);
            } else {
                try {
                    t.join();
                    System.out.println(content);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //打印十次ABC;
    public static void print10(){
        for (int i = 0; i <printABC10times.a.length;  i++) {
            new Thread(new printABC10times(i)).start();
        }
    }
    public static class printABC10times implements Runnable{
        private int idx ;
        public static String[] a = {"A","B","C"};
        private static int index;

        public printABC10times(int idx) {
            this.idx = idx;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (a){
                        while (idx != index){
                            a.wait();
                        }
                        System.out.print(a[index]);
                        if (index == a.length-1){
                            System.out.println();
                        }
                        index = (index + 1) % a.length;
                        a.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        //printABC();
        print10();
    }
}
