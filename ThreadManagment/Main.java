public class Main {
    public static void main(String[] args) {

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Thread producerThread = new Thread(consumer);
        Thread consumerThread = new Thread(producer);

        producerThread.start();
        consumerThread.start();

    }
}
