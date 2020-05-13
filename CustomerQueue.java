import java.util.NoSuchElementException;

/**
 * This class represents a delivery heap-based priority queue
 * 
 * @author granttostenrud
 *
 */
public class CustomerQueue {
  // Customer queue member variables
  private static final int INITIAL_CAPACITY = 20;
  private Customer[] heap;
  private int size;
  /**
   * No argument constructor for CustomerQueue class
   */
  public CustomerQueue() {
    size = 0;
    heap = new Customer[INITIAL_CAPACITY];
  }
  /**
   * This method adds a new customer to this priority queue and increases queue size if needed
   * 
   * @param customer - the customer to add to the queue
   */
  public void addCustomer(Customer customer) {
    // double size of queue if the queue is at its maximum capacity
    if (size == heap.length) {
      // make copy of original queue
      Customer[] copy = heap;
      // create new array of double length
      heap = new Customer[2*heap.length];
      // copy original queue into new array
      for (int i = 0; i < copy.length; i++) {
        heap[i] = copy[i];
      }
    }
    // insert new customer at queue's next index and increment size
    heap[size] = customer;
    size++;
    // percolate up until there are no heap violations
    percolateUp(size - 1);
  }
  /**
   * This method removes and returns the highest priority customer from this priority queue,
   *  
   * @throws NoSuchElementException - if removing customer results in an empty heap
   * @return - highest priority customer from the priority queue that is removed
   */
  public Customer getNextCustomer() throws NoSuchElementException {
    // check if heap is empty
    if (isEmpty()) {
      throw new NoSuchElementException("Warning: Empty heap!");
    }
    // swap root and last index then remove last index
    Customer placeholder = heap[0];
    heap[0] = heap[size - 1];
    heap[size - 1] = null;
    // decrement size
    size--;
    // heapify queue
    heapify();
    return placeholder;
  }
  /**
   * This method returns, without removing, the highest priority customer
   * 
   * @throws NoSuchElementException - if heap is empty
   * @return - highest priority customer within heap
   */
  public Customer peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Warning: Empty heap!");
    }
    return heap[0];
  }
  /**
   * @return - number of customers in this priority queue
   */
  public int getSize() {
    return size;
  }
  /**
   * @return - true if heap is empty, false otherwise
   */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }
  /**
   * This helper method recursively propagates heap order violations up
   * 
   * @param index of starting node
   */
  private void percolateUp(int index) {
    // if node index is 0, return (base case)
    if (index == 0) return;
    // get parent index
    int parentIndex = getParentIndex(index);
    // if node index is less than parent, swap node and parent
    if (heap[index].compareTo(heap[parentIndex]) < 0) {
      Customer placeholder = heap[index];
      heap[index] = heap[parentIndex];
      heap[parentIndex] = placeholder;
    }
    // recursive call with parent index
    percolateUp(parentIndex);
  }
  /**
   * This helper method recursively propagates heap order violations down
   * 
   * @param index - index of starting node
   */
  private void percolateDown(int index) {
    // if child index is outside of queue size, return (base case)
    if (getLeftChildIndex(index) >= size || getLeftChildIndex(index) == -1) return;
    // get Delivery object for index and its left and right children
    Customer min = heap[index];
    Customer leftChild = null;
    Customer rightChild = null;
    int minIndex = index;
    if (getLeftChildIndex(index) > 0) leftChild = heap[getLeftChildIndex(index)];
    if (getRightChildIndex(index) > 0) rightChild = heap[getRightChildIndex(index)];
    // find max
    if (leftChild != null && leftChild.compareTo(min) < 0) {
      min = leftChild;
      minIndex = getLeftChildIndex(index);
    }
    if (rightChild != null && rightChild.compareTo(min) < 0) {
      min = rightChild;
      minIndex = getRightChildIndex(index);
    }
    // if max isn't node index, swap node with max
    if (min != heap[index]) {
      Customer placeholder = heap[index];
      heap[index] = heap[minIndex];
      heap[minIndex] = placeholder;
    }
    // recursive call with left child index
    percolateDown(getLeftChildIndex(index));
  }
  /**
   * This helper method eliminates all heap order violations from the heap array
   */
  private void heapify() {
    int startingIndex = Math.floorDiv(size, 2) - 1;
    for (int i = startingIndex; i >= 0; i--) {
      percolateDown(i);
    }
  }
  /**
   * @param index - index of Customer
   * @return index of parent
   */
  private int getParentIndex(int index) {
    return Math.floorDiv(index - 1, 2);
  }
  /**
   * @param index - index of customer
   * @return index of left child of customer
   */
  private int getLeftChildIndex(int index) {
    int leftChildIndex = 2 * index + 1;
    if (leftChildIndex >= size) {
      return -1;
    } else {
      return leftChildIndex;
    }
  }
  /**
   * @param index - index of customer
   * @return index of right child of customer
   */
  private int getRightChildIndex(int index) {
    int rightChildIndex = 2 * index + 2;
    if (rightChildIndex >= size) {
      return -1;
    } else {
      return rightChildIndex;
    }
  }
  /**
   * This method gives a string representation of the customer queue
   * 
   * @return - String representation of size and contents of this customer queue
   */
  @Override
  public String toString() {
   String string = "This customer queue contains " + size + " customers";
   if (size == 0) {
   return string;
   }
   string += ": [ ";
   for(int i=0; i<size; i++)
   string += "\n" + heap[i].toString();
   string += " ]\n";
   return string;
  }
}
