package myh.Thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MyRunnable implements Runnable{

    private String name;
    private Integer startSleep;
    private Integer endSleep;
    public MyRunnable(String name){
        super();
        this.name = name;
    }
    @Override
    public void run(){
        try {
            this.startSleep = new Random().nextInt(10)*1000;
            Thread.sleep(startSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"线程开启 "+new SimpleDateFormat("YY-MM-DD HH:mm:ss").format(new Date())+" "+startSleep+"ms后开启");
//      System.out.println(Thread.currentThread().getName()+"：第"+i+"个线程");
        try {
            this.endSleep = new Random().nextInt(10)*1000;
            Thread.sleep(endSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"线程结束 "+new SimpleDateFormat("YY-MM-DD HH:mm:ss").format(new Date())+" "+endSleep+"ms后结束");
    }
}
