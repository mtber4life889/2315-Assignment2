/* Programmer: Curtis Chippeway
 * The purpose of this class is to outline the methods used by a Bag data structure
 * The BagInterface class was supplied by Kenward Chins class notes.
 */
public interface BagInterface<T>
{
	//checks the current number of entries in the bag
   public int getCurrentSize();
   
   //checks if the bag is empty
   public boolean isEmpty();

   //adds a specified newEntry to the bag
   public boolean add(T newEntry);

   //removes a random/unspecified entry from the bag
   public T remove();

   //removes one copy/occurrence of a specified anEntry from the bag
   public boolean remove(T anEntry);
   
   //empties the bag
   public void clear();

   //gets the number of duplicates a specified anEntry has in the bag
   public int getFrequencyOf(T anEntry);

   //test a bag to see if it contains the specified anEntry
   public boolean contains(T anEntry);
   
   //copies the contents of the bag into a new array
   public T[] toArray();

}

