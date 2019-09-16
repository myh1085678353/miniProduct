package myh.Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSafe {
    public static Integer count = 0;
    public static void main(String[] args){
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<20; j++){
                        threadNotSafe1();
                    }
                }
            });
            thread.start();
        }
    }

    //线程不安全
    public static void threadNotSafe(){
        System.out.println(Thread.currentThread().getName()+"开始："+count);

        int z = 1;
        int j = z++;

        count++;

        System.out.println(Thread.currentThread().getName()+"结束："+count);
    }

    /**
     * 线程安全
     * 线程安全问题：主要原因有：1、存在共享数据 2、多线程共同操作共享数据
     * synchronized 可以保证在同一个时刻只有一个线程可以执行某个方法或者某个代码块
     */
    synchronized public static void threadNotSafe1(){
        System.out.println(Thread.currentThread().getName()+"开始："+count);

        int z = 1;
        int j = z++;

        count++;

        System.out.println(Thread.currentThread().getName()+"结束："+count);
    }
}
