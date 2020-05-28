package MoPo_Thread;

import java.util.concurrent.*;

public class ThreadPool {

    //四种Executor创建线程池的方法,不推荐使用;
    //《阿里巴巴Java开发手册》中强制线程池不允许使用 Executors 去创建，
    // 而是通过 new ThreadPoolExecutor 实例的方式，
    // 这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
    private static ExecutorService FIXED_POOL = Executors.newFixedThreadPool(4);

    private static ScheduledExecutorService SCHEDULED_POOL = Executors.newScheduledThreadPool(4);

    public static void runFixedThreadPool(Runnable task){
        FIXED_POOL.execute(task);
    }

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
