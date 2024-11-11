public class Consumer implements Runnable
{
    private Message box;

    public Consumer()
    {
        this.box = Message.GetInstance();
    }

    @Override
    public void run()
    {
        for(int i = 1; i<=10;i++)
        {
            String message =box.Remove();
            System.out.println("[Consumer] Deleted - "+message);
        }
    }

}
