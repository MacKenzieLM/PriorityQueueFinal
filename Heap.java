
package priorityqueue2final;



/**
 * This is heap class but I have not been able to implement the methods
 * @ author Lauren Smart 19016480
 * @param <T>
 */
public class Heap <T> implements PriorityQueue<T>{
   
    // class variables
    private final int[] heapArray;
    // size of array
    private int maxSize;
    // number of nodes in array
    private int heapSize;
    
    T item;
    int priority;
    private int size;
    /*
     * Constructor for heap class
     */
    public Heap() 
    {
        this.maxSize = size;
        this.heapSize = 0;
        heapArray = new int[this.maxSize];
    }


    /*
     * Method to return head node of heap class
     */
    @Override
    @SuppressWarnings("unchecked")
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return (T) heapArray;
        }

    }

    /*
     * method for checking of the queue is empty
     */
    @Override
    public boolean isEmpty() {
        // if heap size is equal to 0, then return empty
        return heapSize == 0;
    }

    /*
     * method for returning the parent node and its set priority
     */
    public int getParentNode(int priority) {
        return (priority - 1) / 2;
    }

    /*
     * method for returning the left child node and its set priority
     */
    public int getLeftChild(int priority) {
        return 2 * priority + 1;
    }

    /*
     * method for returning the right child node and its set priority
     */
    public int getRightChild(int priority) {
        return 2 * priority + 2;
    }
    
    /*
    * Method to create a swap node to swap the first with the second nodes
    */ 
   
    private void swap(int firstNode, int secondNode)  {   
        int temp;   
        temp = heapArray[firstNode];   
        heapArray[firstNode] = heapArray[secondNode];   
        heapArray[secondNode] = temp;   
    }   

    /*
     * Method to add a node into heap array
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {

        int parentNode = (priority - 1) / 2;
        int leftChild =  2 * priority + 1;
        int rightChild = 2 * priority + 2;
        int current = heapSize;
        
        PriorityItem<T> queue = new PriorityItem<>(item, priority);
        if (heapSize + 1 == heapSize) {
            heapArray[++heapSize] = priority;

            int pos = heapSize;
            while (pos != 1 && priority > heapArray[pos / 2]) {
              
                
                int temp;   
                int firstNode = 0;
        
                temp = heapArray[firstNode];   
                int secondNode = 0;
                heapArray[firstNode] = heapArray[secondNode];   
                heapArray[secondNode] = temp;   
                swap(current, getParentNode(current));   
                current = getParentNode(current);   
                }   
                    heapSize++;   
                
        }
    }

    /**
     * Method to remove node
     **/
    @Override
    public void remove() throws QueueUnderflowException 
    {
        // set local variables
        int parentNode = 1;
        int childNode = 2;
        int temp;
        
        // check queue is empty
        if (isEmpty())
        {
            throw new RuntimeException("Error : Heap empty!");
        }
            temp = heapArray[heapSize--];

        // while loop to check the child nodes is lesser than size 
        while (childNode <= heapSize) 
        {
            // if statement to check 
            if (childNode < heapSize && heapArray[childNode] < heapArray[childNode + 1]) 
            {
                // increment child node
                childNode++;
            }
                // if temp variable is greater, 
                if (temp >= heapArray[childNode]) {
                    break;
            }

            heapArray[parentNode] = heapArray[childNode];
            parentNode = childNode;
            childNode *= 2;
        }
        heapArray[parentNode] = temp;

    }


    /**
     * Method to print values
     **/
    @Override
      public String toString() {
    /* Array format */
       String result = "[";

       for (int i = 1; i < heapSize; i++) {
           if (i > 0) {result += ", ";
           }
          result = result + heapArray[i];
       }
        result += "]";
       return result;

      }



    }

