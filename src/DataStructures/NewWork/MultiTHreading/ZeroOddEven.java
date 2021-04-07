package DataStructures.NewWork.MultiTHreading;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ZeroOddEven {
    public static void main(String[] args) {
//        Thread t1 = new Thread()
    }
}


class ZeroEvenOdd implements Callable {
    private int n;

    Semaphore even, odd, zero;
    AtomicInteger at;

    public ZeroEvenOdd(int n) {
        this.n = n;
        at = new AtomicInteger(0);
        zero = new Semaphore(1);
        even = new Semaphore(0);
        odd = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero() throws InterruptedException {
        boolean isOdd = true;

        for (int i = 0; i < n; i++) {
            zero.acquire();
            System.out.println(0);

            if (isOdd) odd.release();
            else even.release();

            isOdd = !isOdd;
        }
    }

    public void even() throws InterruptedException {

        even.acquire();
        at.incrementAndGet();
        System.out.println(at.get());
        zero.release();
    }

    public void odd() throws InterruptedException {
        odd.acquire();
        at.incrementAndGet();
        System.out.println(at.get());
        zero.release();
    }


    @Override
    public Object call() throws Exception {
        return null;
    }
}