public class ThreadSumExample
{
    public static void main(String[] args)
    {
        Thread[] threads = new Thread[5];
        RandomNumberGenerator[] generators = new RandomNumberGenerator[5];

        for (int i = 0; i < 5; i++)
        {
            generators[i] = new RandomNumberGenerator();
            threads[i] = new Thread(generators[i]);
            threads[i].start();
        }

        for (int i = 0; i < 5; i++)
        {
            try
            {
                threads[i].join();
            } catch (Exception e)
            {
                System.out.println("Something Wrong happend");
            }
        }
        int sum = 0;
        for ( RandomNumberGenerator rng : generators)
        {
            sum += rng.getRandomNumber();
        }

        System.out.println("Sum of generated numbers: " + sum);
    }
}