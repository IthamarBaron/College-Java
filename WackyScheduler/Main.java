import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        //innit the apps and threads
        Thread[] threads = new Thread[5];
        Application[] apps = new Application[5];
        for(int i=0;i<5;i++)
        {
            apps[i] = new Application(i,true);
            threads[i] = new Thread(apps[i]);
        }

        //data generation
        int length = 25;
        int[] messages = new int[length+1];
        Random rand = new Random();
        for(int i=0;i<length;i++)
        {
            int data = rand.nextInt(100);
            messages[i] = data;
        }
        messages[length] = -1;

        //start threads
        for(int i=0;i<5;i++)
            threads[i].start();


        //scheduler
        int index = 0;
        while (messages[index] != -1)
        {
            int threadIndex = messages[index] % 5; //getting a random Thread ID 0-4
            apps[threadIndex].Write(messages[index++]);
        }
    }

}
