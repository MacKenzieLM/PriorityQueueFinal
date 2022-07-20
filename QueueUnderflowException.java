package priorityqueue2final;

/**
 * Queue is empty.
 *
 * Cannot access or remove an item from an empty queue.
 */
public class QueueUnderflowException extends Exception {

    public QueueUnderflowException() {
        super("Queue is empty");
    }
}
