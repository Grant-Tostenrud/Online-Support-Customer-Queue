# Online Support Customer Queue
This project represents a priority queue for an online tech help customer queue. Each customer has a name and a priority number. Once an agent is available, the customer with the lowest priority number is selected to receive help, and the queue is updated. The priority numbers are based on when the customer entered the queue and how urgent they need assistance based on their issue(s). Customers that have been in line longer will have lower priority numbers than those who got in line more recently, and customers with a more urgent issue will have a lower priority number. If two customer's have the same priority number, then the customer that was already in line will be in front of the new customer.

The files in this repo are Customer.java, CustomerQueue.java, and CustomerQueueTester.java.

Customer.java - represents a single customer
CustomerQueue.java - represents a queue of customers
CustomerQueueTester.java - tests the correctness of the Customer and CustomerQueue classes

## Built With

* Java 11.0.6
* Eclipse IDE - execution environment for Java

## Prerequisites
* Install Java Environment - instructions can be found at https://java.com/en/download/help/download_options.xml
* If desired, instructions to set up the Eclipse IDE can be found at https://www.eclipse.org/downloads/packages/installer

## Deployment

Download source code and run on OpenJDK Runtime Environment AdoptOpenJDK

## Authors

* **Grant Tostenrud** - (https://github.com/Grant-Tostenrud)
