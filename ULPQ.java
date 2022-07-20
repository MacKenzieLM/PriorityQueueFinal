
package priorityqueue2final;

/**
 * Class for unsorted linked priority queue.  I have referenced the following 
 * in order to help me code the class - 
 * https://stackoverflow.com/questions/25437682/use-a-linked-list-to-implement-a-priority-queue
 * and 
 * https://www.javatpoint.com/java-program-to-delete-a-node-from-the-beginning-of-the-singly-linked-list
 * @author Lauren Smart 19016480
 */
public class ULPQ <T> implements PriorityQueue<T> {
    
    // class variables
    T item;
    int biggestPriority = -1;
    ListNode<T> headNode;
    int tailNode = 0;

    ListNode<T> currNode = headNode;
    ListNode<T> currentNode;
    ListNode<T> prev = headNode;
    ListNode<T> next;
    ListNode<T> temp;
    int position = 0;
    int size;

    /**
     * Constructor for class
     */
    public ULPQ() {
        headNode = null;
        size = 0;
    }

    
    /**
     * Method for testing head node. Returns the head of queue.
     * based on code 
     */
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {

            throw new QueueUnderflowException();
        } else {
            ListNode<T> node = headNode;
            // while current node is not empty, traverse through all nodes
            while (node != null) {
                // if statement to compare current nodes to the biggest priority in the queue
                if (node.getPriority() > biggestPriority) {
                    item = node.getItem();
                    biggestPriority = node.getPriority();
                }
                node = node.next;
            }
        }
        biggestPriority = -1;
        return item;

    }

    /*
     * Insert method using  method
     */
    @SuppressWarnings("unchecked")
    @Override
    public void add(T item, int priority) throws QueueOverflowException {

        // set object next,prev and temp to null
        ListNode<T> next, prev, temp = null;
        // create new instance of next node
        next = new ListNode<>(item, priority);
        // set boolean of node insert to false
        boolean insert = false;
        // if statement to check head node is null and set headnode to next node
        if (headNode == null) {
            headNode = next;
        } else {
            // set temp to headnode
            temp = headNode;
            // set prev to headnode plus next node
            prev = headNode.getNext();

            //
            while (prev != null) {
                if (priority >= temp.priority && priority <= prev.priority) {
                    temp.setNext(next);
                    next.setNext(prev);
                    insert = true;
                    break;
                } else {
                    temp = prev;
                    prev = prev.getNext();
                }
            }
            if (insert == false) {
                temp.setNext(next);
            }
        }
        size++;
    }

    /**
     * Method for removing node using following code to assist ref
     * https://stackoverflow.com/questions/25437682/use-a-linked-list-to-implement-a-priority-queue
     * ref
     * https://www.javatpoint.com/java-program-to-delete-a-node-from-the-beginning-of-the-singly-linked-list
     *
     * @throws QueueUnderflowException
     */
    @Override
    public void remove() throws QueueUnderflowException {

        T head = head();

        if (isEmpty()) {

            throw new QueueUnderflowException();
        } else {
            // set current node to second node in the list
            // during testing if this was set earlier it resulted in a null pointer exception
            currentNode = headNode.next;
            prev = headNode.prev;

            // head is found in the first node
            if (headNode.getItem() == head) {

                headNode = currentNode;
            } else {
                // traverse list until the head is found
                while (currentNode.getItem() != head) {

                    prev = prev.next;
                    currentNode = currentNode.next;
                }
                // head is the last node in the list
                if (currentNode.next == null) {

                    prev.next = null;
                } // head is in the middle of the list
                else {

                    prev.next = currentNode.next;
                }
            }
        }
    }

    /*
     * method for checking if sorted linked list is empty
     */
    @Override
    public boolean isEmpty() {
        return headNode == null;
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
            string += currNode.getItem().toString() + " " + currNode.priority + ", ";
            currNode = currNode.getNext();
        }
     //   string = string.replaceAll(", $", "");
        String result = "[" + string + "]";
        return result;
    }

}

    
