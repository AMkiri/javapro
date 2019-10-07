package skillbox.amkiri.module6.hw1;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DepositAcc extends Account {

    private LocalDate lastFundDate = LocalDate.MIN;

    DepositAcc(BigDecimal startAmount) {
        super(startAmount);
    }

    @Override
    public boolean withdrow(BigDecimal amount) {
        if (lastFundDate.isAfter(LocalDate.now().minusDays(30))) {
            return false;
        }

        if (isAmountAvailable(amount)) {
            availableAmount = availableAmount.subtract(amount);
            return true;
        }

        return false;
    }

    @Override
    public boolean fund(BigDecimal amount) {
        availableAmount = availableAmount.add(amount);
        lastFundDate = LocalDate.now();
        return true;
    }

    @Override
    public String getAccountName() {
        return "Deposit";
    }
}
