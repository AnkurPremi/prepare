package Interview.AdaptorPattern;

import java.util.concurrent.*;
import java.util.function.DoubleBinaryOperator;

public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Aggregator());
        Thread t = null;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                t = new Thread(new Cycle(cyclicBarrier), "Processing-" + i);
            else
                t = new Thread(new DBData(cyclicBarrier), "DBData-" + i);

            t.start();
            Thread.sleep(2000);
        }
    }
}

class DBData implements Runnable {
    CyclicBarrier cyclicBarrier;

    public DBData(CyclicBarrier barrier) {
        this.cyclicBarrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("getting data from the data base -" + Thread.currentThread().getName());
            for (int i = 0; i < 3; i++) {
                System.out.println(" Sql query result - " + i);
                Thread.sleep(2000);
            }
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Cycle implements Runnable {
    CyclicBarrier cyclicBarrier;

    public Cycle(CyclicBarrier barrier) {
        this.cyclicBarrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            String name = Thread.currentThread().getName();
            System.out.println("Executing thread - >" + name);
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Aggregator implements Runnable {

    @Override
    public void run() {
        System.out.println("Aggregating");
    }
}
