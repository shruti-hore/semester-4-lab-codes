import java.util.*;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public void viewCustomers() {
        for(Customer c : customers) {
            System.out.println(c);
        }
    }
}