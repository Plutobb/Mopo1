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

    public static void main(String[] args) {
        //这里sum输出的值跟预想的不符合,涉及到了线程安全问题;
        //unSafetyThread();
    }
}
