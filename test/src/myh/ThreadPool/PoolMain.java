package myh.ThreadPool;

import java.util.concurrent.*;

public class PoolMain {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();
    }

    public void executor(){
        /*
        int corePoolSize, // 线程池长期维持的线程数，即使线程处于Idle状态，也不会回收。
        int maximumPoolSize, // 线程数的上限
        long keepAliveTime, TimeUnit unit, // 超过corePoolSize的线程的idle时长，
                                 // 超过这个时间，多余的线程会被回收。TimeUnit(单位)
        BlockingQueue<Runnable> workQueue, // 任务的排队队列
        ThreadFactory threadFactory, // 新线程的产生方式
        RejectedExecutionHandler handler) // 拒绝策略
         */
        ExecutorService executorService = new ThreadPoolExecutor(2,2,
                0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(512),
                new ThreadPoolExecutor.DiscardPolicy());

        ThreadPoolExecutor t = new ThreadPoolExecutor(1,3,
                0,TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3));
    }
}
