public class Application implements Runnable
{
    private int ID = -1;
    private boolean isAlive;
    private  int dataCount = 0;
    private int[] data = new int[32];

    public Application(int ID, boolean isAlive) {
        this.ID = ID;
        this.isAlive = isAlive;
    }

    public int GetID()
    {
        return  this.ID;
    }

    public boolean IsAlive()
    {
        return this.isAlive;
    }

    public void Kill()
    {
        this.isAlive = false;
    }


    public synchronized void Read()
    {
        for (;dataCount>0;dataCount--) {
            System.out.println("[APP " + this.ID + "] Read Data (" + data[dataCount] + ")");
            this.data[dataCount] = 0;
        }
    }

    public synchronized void Write(int data)
    {
        this.data[++dataCount] = data;
        this.notify();
    }

    @Override
    public synchronized void run()
    {
        while (!(dataCount>0)){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Read();
    }
}
