package skillbox.amkiri.module6.hw3.clients;

public abstract class Client {

    private static int nextAccountNumber = 0;

    private int accNumber;
    private String name;

    protected double amount = 0;

    public Client(String name) {
        this.name = name;

        accNumber = nextAccountNumber;
        nextAccountNumber++;
    }

    public abstract void withdrow(double amount);

    public abstract void fund(double amount);

    public String getDepositString() {
        return  String.format("%-25s | %-10d | %10.2f", name, accNumber, amount);
    }
}
