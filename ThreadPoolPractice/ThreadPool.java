import java.util.LinkedList;
import java.util.Queue;

public class ThreadPool {
    private final int maxThreads;
    private int activeThreads;
    private final Queue<Thread> waitingThreads;

    public ThreadPool(int maxThreads) {
        this.maxThreads = maxThreads;
        this.activeThreads = 0;
        this.waitingThreads = new LinkedList<>();
    }

    public synchronized void acquire(Thread thread) {
        if (activeThreads < maxThreads) {
            activeThreads++;
            System.out.println(thread.getName() + " acquired, active threads: " + activeThreads);
        } else {
            synchronized (waitingThreads) {
                System.out.println(thread.getName() + " is waiting.");
                waitingThreads.add(thread);
                try {
                    waitingThreads.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public synchronized void release() {
        activeThreads--;
        System.out.println("Thread released, active threads: " + activeThreads);
        synchronized (waitingThreads) {
            if (!waitingThreads.isEmpty()) {
                Thread nextThread = waitingThreads.poll();
                activeThreads++;
                System.out.println(nextThread.getName() + " notified to run, active threads: " + activeThreads);
                waitingThreads.notify();
            }
        }
    }

}

