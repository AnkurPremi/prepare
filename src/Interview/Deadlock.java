package Interview;

public class Deadlock {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadOne());
        Thread t2 = new Thread(new ThreadTwo());

        t1.start();
        t2.start();
    }
}

class ThreadOne implements Runnable {

    @Override
    public void run() {
        synchronized (A.class) {
            try {
                System.out.println("Entered A on ThreadOne");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (B.class) {
                System.out.println("Entered B on ThreadOne");
            }
        }
    }
}

class ThreadTwo implements Runnable {

    @Override
    public void run() {
        synchronized (B.class) {
            try {
                System.out.println("Entered B on ThreadTwo");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (A.class) {
                System.out.println("Entered A on ThreadTwo");
            }
        }
    }
}

class A {

}

class B {

}
