package myh.Thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadMain {

    //简单thread调用
    public static void main(String[] args){
        Fuc_Thread();
        Fuc_Runnable();
    }

    //在主线程中调用
    public static void Fuc_Thread(){
        List<ThreadTest> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            String str = "Thread"+i;
            ThreadTest threadTest1 = new ThreadTest(str);
//            System.out.println(Thread.currentThread().getName());
            list.add(threadTest1);
        }

        list.forEach(threadTest -> threadTest.start());
    }

    public static void Fuc_Runnable(){
        List<MyRunnable> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            String str = "Thread"+i;
            MyRunnable myRunnable = new MyRunnable(str);
//            System.out.println(Thread.currentThread().getName());
            list.add(myRunnable);
        }

        list.forEach(myRunnable -> new Thread(myRunnable).start());
    }

}
