package myh.Thread;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ThreadTest extends Thread{

    private String name;

    public ThreadTest(String name){
        super(name);
        this.name = name;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"线程开启 "+new SimpleDateFormat("YY-MM-DD HH:mm:ss").format(new Date()));
//      System.out.println(Thread.currentThread().getName()+"：第"+i+"个线程");
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"线程结束 "+new SimpleDateFormat("YY-MM-DD HH:mm:ss").format(new Date()));
    }
}
