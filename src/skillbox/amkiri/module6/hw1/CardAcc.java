package skillbox.amkiri.module6.hw1;

import java.math.BigDecimal;

public class CardAcc extends Account {

    private static final BigDecimal FEE = BigDecimal.valueOf(0.01);

    CardAcc(BigDecimal startAmount) {
        super(startAmount);
    }

    @Override
    public boolean withdrow(BigDecimal amount) {
        amount = amount.add(amount.multiply(FEE));

        if (isAmountAvailable(amount)) {
            availableAmount = availableAmount.subtract(amount);
            return true;
        }

        return false;
    }

    @Override
    public boolean fund(BigDecimal amount) {
        availableAmount = availableAmount.add(amount);
        return true;
    }

    @Override
    public String getAccountName() {
        return "Card account";
    }

}
