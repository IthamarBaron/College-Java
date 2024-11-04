import java.util.Random;

class RandomNumberGenerator implements Runnable
{
    private int randomNumber;

    @Override
    public void run()
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(100);
        System.out.println("Generated number: " + randomNumber);
    }

    public int getRandomNumber()
    {
        return randomNumber;
    }
}


