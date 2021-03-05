package DataStructures.NewWork.Misc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DesignBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BoundedBlockingQueue boundedBlockingQueue = new BoundedBlockingQueue(3);
        boundedBlockingQueue.enqueue(3);
        boundedBlockingQueue.enqueue(2);
        boundedBlockingQueue.enqueue(4);
        System.out.println(boundedBlockingQueue.dequeue());
    }
}

class BoundedBlockingQueue {
    private final ReentrantLock putLock = new ReentrantLock();
    private final ReentrantLock takeLock = new ReentrantLock();

    /** Wait queue for waiting puts */
    @SuppressWarnings("serial") // Classes implementing Condition may be serializable.
    private final Condition notFull = putLock.newCondition();
    private final Condition notEmpty = takeLock.newCondition();
    private final int capacity;
    AtomicInteger count = new AtomicInteger();
    private Queue<Integer> queue;
    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        final int c;
        final ReentrantLock putLock = this.putLock;
        final AtomicInteger count = this.count;
        putLock.lock();
        try{
            while (this.count.get() == capacity){
                notFull.await();
            }
            queue.offer(element);
            c = count.getAndIncrement();
            if(c + 1 > capacity){
                notFull.signal();
            }
        } finally {
            putLock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        final int c;
        final int val;
        final ReentrantLock takeLock = this.takeLock;
        final AtomicInteger count = this.count;
        takeLock.lock();
        try{
            while (this.count.get() == 0){
                notEmpty.await();
            }
            val = queue.poll();
            c = count.getAndDecrement();
            if(c > 0){
                notEmpty.signal();
            }
        } finally {
            takeLock.unlock();
        }
        return val;
    }

    public int size() {
        return this.count.get();
    }
}
