public class Main {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            Thread t = new Thread(new Task(threadPool), "Thread-" + i);
            t.start();
        }
    }
}
