package interviewPractice;

import java.util.concurrent.*;

public class DealLock {
    public static void main(String[] args) {
        final String res1 = "Ankur Premi";
        final String res2 = "Neha Premi";
        Thread t1 = new Thread(() ->{
           synchronized (res1){
               System.out.println("Thread - "+ Thread.currentThread().getId() + " has lock on res1");

               try{
                   Thread.sleep(1000);
               }catch (Exception e){e.printStackTrace();}

               synchronized (res2){
                   System.out.println("Thread - "+ Thread.currentThread().getId() + " has lock on res2");
               }
           }
        });

        Thread t2 = new Thread(() ->{
            synchronized (res2){
                System.out.println("Thread - "+ Thread.currentThread().getId() + " has lock on res2");

                try{
                    Thread.sleep(1000);
                }catch (Exception e){e.printStackTrace();}

                synchronized (res1){
                    System.out.println("Thread - "+ Thread.currentThread().getId() + " has lock on res1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
