/* Programmer: Curtis Chippeway
 * The purpose of this class is to be able to create full functioning bags from it
 * The ArrayBag class was supplied by Kenward Chins class notes.
 */
import java.util.Arrays;

public final class ArrayBag<T> implements BagInterface<T> {
	
	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 42;
	
	public ArrayBag()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayBag(int capacity)
	{
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[capacity];
		bag = tempBag;
		numberOfEntries = 0;
	}

	public int getCurrentSize() 
	{
		return numberOfEntries;
	}

	public boolean isEmpty() 
	{
		return numberOfEntries == 0;
	}

	public boolean add(T newEntry)
	{
		boolean result = true;
		
		if(isArrayFull())
		{
			result = false;
		}
		else
		{
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		return result;
	}

	public T remove() 
	{
		T result = removeEntry(numberOfEntries - 1);
		return result;
	}

	public boolean remove(T anEntry)
	{
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	}

	public void clear()
	{
		while(!isEmpty())
		{
			remove();
		}
	}

	public int getFrequencyOf(T anEntry)
	{
		int counter = 0;
		
		for(int index = 0; index < numberOfEntries; index++)
		{
			if (anEntry.equals(bag[index]))
			{
				counter++;
			}
		}
		return counter;
	}

	public boolean contains(T anEntry)
	{
		return (getIndexOf(anEntry) > -1);
	}

	public T[] toArray()
	{
		T[] result = Arrays.copyOf(bag, numberOfEntries);
		return result;
	}

	private boolean isArrayFull()
	{
		return numberOfEntries >= bag.length;
	}
	
	private int getIndexOf(T anEntry)
	{
		int where = -1;
		boolean found = false;
		int index = 0;
		
		while (!found && (index < numberOfEntries))
		{
			if (anEntry.equals(bag[index]))
			{
				found = true;
				where = index;
			}
			index++;
		}
		return where;
	}
	
	private T removeEntry(int givenIndex)
	{
		T result = null;
		
		if (!isEmpty() && (givenIndex >=0))
		{
			result = bag[givenIndex];
			bag[givenIndex] = bag[numberOfEntries-1];
			bag[numberOfEntries-1] = null;
			numberOfEntries--;
		}
		return result;
	}

}