package skillbox.amkiri.module8.hw1;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String customerName) {
        super("No entry to delete. Name: " + customerName);
    }
}
