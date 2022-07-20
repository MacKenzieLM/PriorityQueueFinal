/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue2final;

/**
 *
 * @author PC
 */
public class SLPQ <T> implements PriorityQueue<T> {

    // class variables
    T item;
    int priority;
    ListNode<T> headNode;
    ListNode<T> tailNode = null;
    ListNode<T> currentNode = headNode;
    ListNode<T> prev;
    ListNode<T> next;
    ListNode<T> temp;
    int position = 0;
    int size;

    /**
     * Constructor for class
     *
     */
    public SLPQ() {
        this.headNode = null;
        size = 0;
    }

    /**
     * Method for testing head node. Returns the head of queue.
     *
     */
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>) headNode.getItem()).getItem();
        }
    }

    /*
    * Insert method using bubble sort method
    * https://www.sanfoundry.com/java-program-implement-sorted-singly-linked-list/
     */
    @SuppressWarnings("unchecked")
    @Override
    public void add(T item, int priority) {

        ListNode<T> currentNode = headNode;
        PriorityItem<T> newItem = new PriorityItem<>(item, priority);
        ListNode<T> newNode = new ListNode<>(newItem);

        if (!isEmpty()) {

            // check if new item is higher or the same as the first item
            // if true, add new item to the front of the queue
            if (priority >= ((PriorityItem) headNode.getItem()).getPriority()) {

                headNode = newNode;
                newNode.next = currentNode;
                size++;
            }

            // iterate through list as long as the priority of the new item is less than
            // that of the current item
            while (priority < ((PriorityItem) currentNode.getItem()).getPriority()) {

                // if we reach the end of the queue add the new item to the end
                if (currentNode.next == null) {

                    currentNode.next = newNode;
                    size++;
                } // if the new item is higher or equal in priority to the next item
                // add new item at current position and shuffle the next one along
                else if (priority >= ((PriorityItem) currentNode.next.getItem()).getPriority()) {

                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    size++;
                }

                currentNode = currentNode.next;
            }
        } // if the list is empty add new item as the first node
        else {

            headNode = newNode;
            size++;
        }
    }

    /**
     * Method for removing node ref
     * https://stackoverflow.com/questions/25437682/use-a-linked-list-to-implement-a-priority-queue
     *
     * @throws QueueUnderflowException
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            // If queue is empty, return NULL. 
            if (this.headNode == null) {
                return;
            }
            // Store previous front and move front one node ahead 
            ListNode<T> tempNode = this.headNode;
            this.headNode = this.headNode.next; // If front becomes NULL, then change rear also as NULL 
            if (this.headNode == null) {
                this.tailNode = null;
            }
        }
    }

    /*
    * method for checking if sorted linked list is empty
     */
    @Override
    public boolean isEmpty() {
        return (headNode == null);
    }

    @Override
    public String toString() {
        // Returns a nicely formatted string that represents this priority queue.
        String string = "";
        if (isEmpty()) {
            return "Queue is empty.";
        }
        ListNode<T> currNode = headNode;

        while (currNode != null) {
            string += currNode.getItem().toString() + " ";
            currNode = currNode.getNext();
            
        }
       // string = string.replaceAll(" $", "");
        String result = "[" + string + "]";
        
        return result;
    }
    //  private static final Logger LOG = Logger.getLogger(SortedLinkedPriorityQueue.class.getName());

}

    
    

