package DataStructures.interviewPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(service.submit(new Worker()));
        }
        for (Future<String> future : list) {
            while (!future.isDone()) {
            }
            System.out.println("received data ->" + future.get());
        }
        service.shutdown();
        while (!service.isTerminated()) {
        }
        System.out.println("Work done");
    }
}

class Worker implements Callable {

    @Override
    public String call() throws Exception {
        String a = String.valueOf(ThreadLocalRandom.current().nextInt(1, 10000));
        System.out.println("Got this data after hard work - " + a + " Thread name is " + Thread.currentThread().getName());
        try {
            ExecutorService service = Executors.newFixedThreadPool(5);
            List<Future<String>> list = new ArrayList<>();
            for (int i = 0; i < 1; i++) {
                list.add(service.submit(new SmallWorker()));
            }
            for (Future<String> future : list) {
                while (!future.isDone()) {
                }
                System.out.println("received data from SmallWorker ->" + future.get());
            }
            service.shutdown();
            while (!service.isTerminated()) {
            }
            System.out.println("Work done SmallWorker");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a;
    }
}

class SmallWorker implements Callable{

    @Override
    public String call() throws Exception {
        System.out.println("Got this data after hard work Thread name is " + Thread.currentThread().getName());
        return String.valueOf(ThreadLocalRandom.current().nextInt(999999, 9999999));
    }
}