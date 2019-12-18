package skillbox.amkiri.module8.hw1;

import java.util.HashMap;

/**
 * Manage customers.
 * Key field: "Name Surname"
 */
public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    /**
     * Add new customer. Update data if exist.
     */
    public void addCustomer(Customer customer)
    {
        storage.put(customer.getName(), customer);
    }

    /**
     * Print all customers to standard output
     */
    public void listCustomers()
    {
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
     * @throws IllegalArgumentException if there wasn't such entry
     */
    public void removeCustomer(String name)
    {
        if (!storage.containsKey(name)) {
            throw new IllegalArgumentException("No entry to delete. Name: " + name);
        } else {
            storage.remove(name);
        }
    }

    /**
     * @return number of entries
     */
    public int getCount()
    {
        return storage.size();
    }
}