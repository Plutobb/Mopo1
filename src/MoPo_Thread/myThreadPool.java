package MoPo_Thread;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class myThreadPool {
    private BlockingQueue<Runnable> queue;//仓库：可以使用自定义的阻塞队列

    //创建快递公司
    public myThreadPool(int corePoolSize, int capacity){
        //创建仓库
        queue = new ArrayBlockingQueue<>(capacity);
        //招聘员工
        for(int i=0; i<corePoolSize; i++){
            new myThread(queue).start();
        }
    }
    //快递公司开放出来送快递的接口（电话、营业点）：
    // 客户调用接口（打电话，去营业点办业务）。快递包裹存放在仓库中
    public void execute(Runnable commend) throws InterruptedException {
        queue.put(commend);
    }

    //这里while循环 正式员工一直干活；
    private static class myThread extends Thread{
        private BlockingQueue<Runnable> queue;

        public myThread(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true){
                    //员工取出仓库中的快递，没有取到就阻塞等待;
                    Runnable task = queue.take();
                    task.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
