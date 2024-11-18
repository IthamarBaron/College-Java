import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args)
    {
        Collection<Integer> arrList = new ArrayList<Integer>();
        for (int i= 0; i<10;i++)
        {
            arrList.add(i+1);
        }
        StepIterator<Integer> stepIterator = null;
        try
        {
            stepIterator= new StepIterator<Integer>(2,arrList);
        }
        catch (BadStepException e)
        {
            System.out.println( e.getMessage());
        }
        if (stepIterator != null)
        {
            while (stepIterator.hasNext()){
                System.out.println(stepIterator.next());
            }

        }
    }
}