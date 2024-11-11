class Task implements Runnable {
    private final ThreadPool threadPool;

    public Task(ThreadPool threadPool) {
        this.threadPool = threadPool;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " calling acquire");
            threadPool.acquire(Thread.currentThread());

            System.out.println(Thread.currentThread().getName() + " after acquire DOING WORK");
            Thread.sleep(500);

            System.out.println(Thread.currentThread().getName() + " FINISHED WORK - RELEASING");
            threadPool.release();

            System.out.println(Thread.currentThread().getName() + " AFTER RELEASE");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}