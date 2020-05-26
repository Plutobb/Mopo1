package MoPo_Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) {
        //线程池
        //通过送快递来理解线程池;

        //相当于创建一个快递公司;
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                //公司快递员数量(正式工) -------线程数量;
                4,
                //公司最多快递员数量(正式工,和临时工)  ------线程最大数量;
                10,
                //临时工最多空闲时间,如果超过这个时间就结束线程,
                60,
                //时间单位;
                TimeUnit.SECONDS,
                //快递仓库来存放需要送的快递   ------存放线程的容器;
                new ArrayBlockingQueue<>(1000),
                //线程工厂,来按照你的方法送快递   ------产生线程的方法;
//                new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        return (Thread) r;
//                    }
//                },
                //拒绝策略:当库存满的时候
                new ThreadPoolExecutor.AbortPolicy()
        );
        pool.execute(()->{
            System.out.println("送快递到西安");
        });
        pool.execute(()->{
            System.out.println("送快递到郑州");
        });
    }
}
