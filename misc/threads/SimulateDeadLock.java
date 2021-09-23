package misc.threads;

public class SimulateDeadLock {
    public static Integer lock1 = 1;
    public static Integer lock2 = 2;

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread1 attempting to acquire Lock1");
        synchronized (SimulateDeadLock.lock1) {
            try {
                System.out.println("Thread1 acquired Lock1");
                System.out.println("Thread1 sleeping for 1000 milli seconds");
                Thread.sleep(1000);
                System.out.println("Thread1 woke up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1 attempting to acquire Lock2");
            synchronized (SimulateDeadLock.lock2) {
                System.out.println("Thread1 acquired Lock2");
                System.out.println("Printing lock2 " + SimulateDeadLock.lock2);
            }
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread2 attempting to acquire Lock2");
        synchronized (SimulateDeadLock.lock2) {
            System.out.println("Thread2 acquired Lock2");
            System.out.println("Thread2 attempting to acquire Lock1");
            synchronized (SimulateDeadLock.lock1) {
                System.out.println("Thread2 acquired Lock1");
                System.out.println("Printing lock1 " + SimulateDeadLock.lock1);
            }
        }
    }
}