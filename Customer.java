/**
 * This class represents a delivery between a student and a robot
 * 
 * @author granttostenrud
 *
 */
public class Customer implements Comparable<Customer>{
  // Delivery member variables
  private int priorityNum;
  private String customerName;
  /**
   * Constructor for Customer class
   * 
   * @param priorityNum - priority number within the line to get online support
   * @param customerName - name of Customer
   */
  public Customer(int priorityNum, String customerName) {
    this.priorityNum = priorityNum;
    this.customerName = customerName;
  }
  
  /**
   * This method compares two Customer objects
   * 
   * @param deliveryObj - the customer object to compare to this class's customer object
   * @return - a negative number if the object called on has higher priority than customerObj. A
   *         positive number if the object called on has lower priority than customerObj
   */
  @Override
  public int compareTo(Customer customerObj) {
    // compare priority numbers
    if (priorityNum - customerObj.priorityNum < 0) {
      return -1;
    } else if (priorityNum - customerObj.priorityNum > 0) {
      return 1;
    } else { // if numbers are equal, then the customer object called on has the higher priority
      return 1;
    }
  }
  /**
   * This method compares two customers to determine if they are equal
   * 
   * @return true if they are equal, false otherwise
   */
  public boolean equals(Customer customer) {
    // return true if priority numbers are the same
    return (priorityNum == customer.priorityNum);   
  }
  
  /**
   * @return String representation showing the customer name and priority number
   */
  @Override
  public String toString() {
   return "Customer Name: " + customerName + ", Priority Number: " + priorityNum;
  }
}
