package priorityqueue2final;



/**
 * This class is my helper class for sorted and unsorted linked 
 * lists to implement the nodes required.
 * 
 * @author Lauren Smart
 */
public class ListNode <T>
{
    
     
    T item;
    int priority;
    ListNode<T> next;
    ListNode<T> prev;
    ListNode<T> tailNode;
    ListNode<T> headNode;
    ListNode<T> currNode;

    public ListNode(PriorityItem newItem) {
       this.item = (T)newItem;
    }

    public ListNode<T> getTailNode() {
        return tailNode;
    }

    public void setTailNode(ListNode<T> tailNode) {
        this.tailNode = tailNode;
    }

    public ListNode<T> getHeadNode() {
        return headNode;
    }

    public void setHeadNode(ListNode<T> headNode) {
        this.headNode = headNode;
    }

    public ListNode<T> getCurrNode() {
        return currNode;
    }

    public void setCurrNode(ListNode<T> currNode) {
        this.currNode = currNode;
    }
    
    
    public ListNode(T item, int priority){
        this.item= item;
        this.priority=priority;
        this.next=null;
      
    }
    
    @SuppressWarnings("unchecked")
    public void setItem(T item){
        this.item=  item;

    }
    public void setNext(ListNode<T> next){
        this.next= next;
    }
    public void setPrev(ListNode<T> prev){
        this.prev = prev;
    }
    
    /**
     *
     * @return
     */
    public T getItem(){
        return item;
    }
    
    public ListNode<T> getNext(){
        return next;
    }
    
    public ListNode<T> getPrev(){
        return prev;
    }

    public int getPriority() {
        return priority;
      
    }

    
}

    
//    T item;
//    int priority;
//    ListNode<T> next;
//    ListNode<T> prev;
//    ListNode<T> tailNode;
//    ListNode<T> headNode;
//    ListNode<T> currNode;
//
//    public ListNode(PriorityItem newItem) {
//       
//    }
//
//    public ListNode<T> getTailNode() {
//        return tailNode;
//    }
//
//    public void setTailNode(ListNode<T> tailNode) {
//        this.tailNode = tailNode;
//    }
//
//    public ListNode<T> getHeadNode() {
//        return headNode;
//    }
//
//    public void setHeadNode(ListNode<T> headNode) {
//        this.headNode = headNode;
//    }
//
//    public ListNode<T> getCurrNode() {
//        return currNode;
//    }
//
//    public void setCurrNode(ListNode<T> currNode) {
//        this.currNode = currNode;
//    }
//    
//    
//    public ListNode(T item, int priority){
//        this.item= item;
//        this.priority=priority;
//        this.next=null;
//      
//    }
//    
//    @SuppressWarnings("unchecked")
//    public void setItem(T item){
//        this.item=  item;
//
//    }
//    public void setNext(ListNode<T> next){
//        this.next= next;
//    }
//    public void setPrev(ListNode<T> prev){
//        this.prev = prev;
//    }
//    
//    /**
//     *
//     * @return
//     */
//    public T getItem(){
//        return item;
//    }
//    
//    public ListNode<T> getNext(){
//        return next;
//    }
//    
//    public ListNode<T> getPrev(){
//        return prev;
//    }
//
//    public int getPriority() {
//        return priority;
//      
//    }
//
//    
//}