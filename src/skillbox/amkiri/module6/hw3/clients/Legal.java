package skillbox.amkiri.module6.hw3.clients;

public class Legal extends Client {

    private static double WITHDROW_TAXES = 0.01;

    public Legal(String name) {
        super(name);
    }

    @Override
    public void withdrow(double amount) {

        amount += amount * WITHDROW_TAXES;

        if (this.amount >= amount) {
            this.amount -= amount;
        }
    }

    @Override
    public void fund(double amount) {
        this.amount += amount;
    }
}
