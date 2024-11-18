import java.util.Collection;
import java.util.Iterator;

public class StepIterator<T> implements Iterator<T> {

    private Collection<T> originalCollection;
    private int steps;
    private int currentPosition = 0;

    public StepIterator(int _steps, Collection<T> _originalCollection) throws BadStepException
    {
        if (_steps <= 0)
            throw new BadStepException("How do you expect me to do " + _steps + " steps? This is not Python!");
        this.originalCollection = _originalCollection;
        this.steps = _steps;
    }

    @Override
    public boolean hasNext() {
        return currentPosition + steps <= originalCollection.size();
    }

    @Override
    public T next() {
        Iterator<T> iterator = originalCollection.iterator();
        T result = null;

        for (int i = 0; i < currentPosition; i++)
        {
            if (iterator.hasNext())
                iterator.next();
        }

        for (int i = 0; i < steps; i++)
        {
            if (iterator.hasNext())
                result = iterator.next();
        }
        currentPosition += steps;

        return result;
    }
}
