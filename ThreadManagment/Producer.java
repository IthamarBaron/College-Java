public class Producer implements Runnable
{
    private Message box;

    public Producer()
    {
        this.box = Message.GetInstance();
    }

    @Override
    public void run()
    {
        for(int i = 1; i<=10;i++)
        {
            String message = "This Is Message [" + i + "]!";
            box.Insert(message);
            System.out.println("[Producer] Inserted message ("+i+")");
        }
    }
}
