public class CustomerQueueTester {
  public static boolean testCustomerQueue() {
    // create a new customer queue
    CustomerQueue minHeap = new CustomerQueue();
    // create some Customer objects
    Customer customer1 = new Customer(10, "Frank");
    Customer customer2 = new Customer(15, "Amy");
    Customer customer3 = new Customer(3, "Tim");
    Customer customer4 = new Customer(1, "Sarah");
    // add customers to customer queue
    minHeap.addCustomer(customer1);
    minHeap.addCustomer(customer2);
    minHeap.addCustomer(customer3);
    minHeap.addCustomer(customer4);

    // check if the size is correct
    if(minHeap.getSize() != 4) return false;
    // check first (highest priority delivery to be returned)
    String nextCustomer = minHeap.getNextCustomer().toString();
    if(!nextCustomer.equals(customer4.toString())) return false;
    // check if the size is correct
    if(minHeap.getSize() != 3) return false;
    // check if peek is correct
    String nextCustomerPeek = minHeap.peek().toString();
    if(!nextCustomerPeek.equals(customer3.toString())) return false;

    // only return true after all previous tests pass
    return true;
   }
  /**
   * Driver method for testing class
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testCustomerQueue());
  }
}
