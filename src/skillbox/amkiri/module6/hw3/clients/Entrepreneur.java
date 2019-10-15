package skillbox.amkiri.module6.hw3.clients;

public class Entrepreneur extends Client {

    private static double FUND_TAXES = 0.01;
    private static double FUND_TAXES_WITH_DISCOUNT = 0.05;

    public Entrepreneur(String name) {
        super(name);
    }

    @Override
    public void withdrow(double amount) {

        if (this.amount >= amount) {
            this.amount -= amount;
        }
    }

    @Override
    public void fund(double amount) {

        if (amount < 1000) {
            amount -= amount * FUND_TAXES;
        } else {
            amount -= amount * FUND_TAXES_WITH_DISCOUNT;
        }

        this.amount += amount;
    }
}
