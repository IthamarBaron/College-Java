public class Message
{
    private String text;
    private boolean empty;
    private static Message instance = null;

    public synchronized void Insert(String text)
    {
        while(!empty)
        {
            try {
                instance.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.text = text;
        this.empty = false;
        instance.notify();
    }

    public synchronized String Remove()
    {
        while(empty)
        {
            try {
                instance.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String holdBeforeDeletion = this.text;
        this.empty = true;
        this.text = "";
        instance.notify();
        return holdBeforeDeletion;
    }

    private Message()
    {
        this.text = "";
        this.empty = true;
    }

    //initialise the singleton
    public static synchronized Message GetInstance() {
        if (instance == null) {
            instance = new Message();
        }
        return instance;
    }

}
