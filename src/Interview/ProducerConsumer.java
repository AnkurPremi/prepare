package Interview;

import java.util.concurrent.*;

public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(10);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new Producer(queue));
        service.submit(new Consumer(queue));
        service.shutdown();
    }
}


class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            try {
                queue.put(i);
                System.out.println("Added-->" + i);
                i++;
                Thread.sleep(500);
            } catch (InterruptedException e) {
                //handle error
            }
        }
    }

}


class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int random = ThreadLocalRandom.current().nextInt(100, 1000);
                Thread.sleep(random);
                int val = queue.take();
                System.out.println("received-->" + val);
            } catch (InterruptedException e) {
                //handle error
            }
        }
    }

}