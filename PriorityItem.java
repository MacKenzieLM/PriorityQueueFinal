package priorityqueue2final;

/**
 * A wrapper for bundling up an item and its integer priority.
 * 
 * @param <T>
 */
public class PriorityItem<T> {

   
     final T item;
    final int priority;
    int size = 0;

    public PriorityItem(T item, int priority) {
        this.item = item;
        this.priority = priority;
        this.size = 0;
    }

    public T getItem() {
        return item;
    }

    public int getPriority() {
        return priority;
    }
    
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "(" + getItem() + ", " + getPriority() + ")";
    }
    
}
