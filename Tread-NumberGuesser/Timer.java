public class Timer extends Thread {

    private boolean running = true;

    public Timer()
    {
        super();
    }

    // Method to stop the timer
    public void stopTimer() {
        running = false;
    }


    // this is the "MAIN" of the thread
    @Override
    public void run() {
        super.run();
        int i = 0;
        while (running) { // Check the flag in the loop
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ++i;
            if (i % 5 == 0) {
                System.out.println("\nTime passed: " + i);
            }
        }
    }
}
