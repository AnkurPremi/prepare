package DataStructures.interviewPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumerWaitNotify {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}

class Producer implements Runnable {

    public Queue<String> queue;

    public Producer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (true) {
                while (queue.size() == 5) {
                    System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + queue.size());
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String a = String.valueOf(ThreadLocalRandom.current().nextInt(1, 99999999));
                System.out.println("adding - " + a);
                queue.offer(a);
                queue.notifyAll();
            }
        }

    }
}


class Consumer implements Runnable {

    public Queue<String> queue;

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (true) {
                while (queue.size() == 0) {
                    System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + queue.size());
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String a = queue.poll();
                System.out.println("removing - " + a);
                queue.notifyAll();
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
