package MoPo_Thread;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

public class ThreadSignal {
    //面包店做面包,假设做大库存为100个;
    //假设五个面包师傅,每次制作3个面包;
    //20个消费者,每次消耗1个面包;
    private static int sum;
    public static void make(){
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    while (true) {
                        synchronized (ThreadSignal.class) {
                            if (sum + 3 > 100) {
                                ThreadSignal.class.wait();
                            } else {
                                sum += 3;
                                System.out.println(Thread.currentThread().getName() + "制作了面包,剩余库存:" + sum);
                                Thread.sleep(50);
                                ThreadSignal.class.notifyAll();
                            }
                            Thread.sleep(20);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"面包师"+"["+i+"]").start();
        }
    }
    public static void consume(){
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                try {
                    while (true) {
                        synchronized (ThreadSignal.class) {
                            if (sum <= 0) {
                                ThreadSignal.class.wait();
                            } else {
                                sum--;
                                System.out.println(Thread.currentThread().getName() + "购买了面包,剩余库存:" + sum);
                                Thread.sleep(50);
                                ThreadSignal.class.notify();
                            }
                            Thread.sleep(20);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"顾客"+"["+i+"]").start();
        }
    }
    public static void main(String[] args) {
        make();
        consume();
    }
}
