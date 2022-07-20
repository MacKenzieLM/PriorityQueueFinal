package priorityqueue2final;

import java.util.logging.Logger;

/**
 * This is the unsorted class for array implementation.  
 * I have reused sorted array class to implement this class.
 * @author PC
 * @param <T>
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {
    
    
     /**
     * Where the data is actually stored.
     */
    private final Object[] storage;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;

    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public UnsortedArrayPriorityQueue(int size) {
        // our data of name and priority in the array
        storage = new Object[size];
        // size of array
        capacity = size;
        // the position of last item in array. 
        // 0 is the start of array and -1 is used to check array is empty.
        tailIndex = -1;
    }
    
    /*
    * This method return the head item of the queue
    */
    @Override
    // check head of queue
    public T head() throws QueueUnderflowException {
          int maxSize = 0;
        int index = 0;
        
        // if the queue is empty,throw the exception
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
             // traverse through all items in the queue
            for (int i = 0; i < tailIndex + 1; i++) {
                // if the priority of the current item is higher than that stored
                // record the position of the current item
                if (((PriorityItem<T>) storage[i]).getPriority() > maxSize) {

                    maxSize = ((PriorityItem<T>) storage[i]).getPriority();
                    index = i;
                }
            } 
            // if queue is not empty the item is stored at index 0
            return ((PriorityItem<T>) storage[index]).getItem();
        }
    }

    /*
    * This method adds an item to the queue
    */
    @Override
    @SuppressWarnings("unchecked")
    public void add(T item, int priority) throws QueueOverflowException 
    {
        // increase tail index by 1, if greater or equal to capacity, 
        // throw queue exception and remove one as we cannot add any more items to array
        tailIndex += 1;
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex -= 1;
            throw new QueueOverflowException();
        } else {
            /* Scan backwards looking for insertion point */
            
            // tail index is the last item
            int i = tailIndex;
            
            // priority in storage is less that the priority we are adding, shift item to the right and put item into that position
            while (i < 0 && ((PriorityItem<T>) storage[i + 1]).getPriority() > priority) {
                storage[i] = storage[i - 1];
                i -= 1;
            }
            // add priority into correct position
            storage[i] = new PriorityItem<>(item, priority);
        }
    }
    

    /*
    * The method removes the head item of the queue
    */    

    @Override
    // remove an object from the array
    public void remove() throws QueueUnderflowException {
          if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {

            int max = 0;
            int index = 0;

            // loop // through all items in the queue
            for (int i = 0; i < tailIndex + 1; i++) {

                // if the priority of the current item is higher than that stored
                // record the position of the current item
                if (((PriorityItem<T>) storage[i]).getPriority() > max) {

                    max = ((PriorityItem<T>) storage[i]).getPriority();
                    index = i;
                }
            }
            // start at the position of the highest priority item and loop through those after it
            // replacing each value with that of the next item
            for (int i = index; i < tailIndex + 1; i++) {

                storage[i] = storage[i + 1];
            }

            // decrement tail index
            tailIndex--;
        }
    }

    /*
    * This method returns a boolean output if queue is empty
    */
    
    @Override
    // checks the array for last item
    public boolean isEmpty() {
        return tailIndex < 0;
    }

    /*
    * This method is for returning the string output 
    */
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result += ", ";
            }
            result += storage[i];
        }
        result += "]";
        return result;
    }
    
      /*
    * I have added this method to allow me to test it 
    * in testing class
    */
    public int size(){
        return capacity;
}
    
    private static final Logger LOG = Logger.getLogger(UnsortedArrayPriorityQueue.class.getName());
}


