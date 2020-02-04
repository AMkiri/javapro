package skillbox.amkiri.module8.hw1;

import java.util.HashMap;

/**
 * Manage customers.
 * Key field: "Name Surname"
 */
public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public boolean isExist(String customerName) {
        return storage.containsKey(customerName);
    }


    public void add(Customer customer) {
        storage.put(customer.getName(), customer);
    }

    /**
     * Print all customers to standard output
     */
    public void list() {
        System.out.println();

        if (storage.isEmpty()) {
            System.out.println("No customers");
        } else {
            storage.values().forEach(System.out::println);
        }

        System.out.println();
    }

    /**
     * Totally removes customer
     * @param name format: "Name Surname"
     * @throws {@link CustomerNotFoundException} if there wasn't such entry
     */
    public void remove(String name) {
        if (!isExist(name)) {
            throw new CustomerNotFoundException(name);
        } else {
            storage.remove(name);
        }
    }

    /**
     * @return number of entries
     */
    public int getCount() {
        return storage.size();
    }
}