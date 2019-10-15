package skillbox.amkiri.module6.hw1;

import java.math.BigDecimal;

public abstract class Account {

    protected BigDecimal availableAmount;

    public Account(BigDecimal startAmount) {
        this.availableAmount = startAmount;
    }

    /**
     * @return true if operation succeeded
     */
    public abstract boolean withdrow(BigDecimal amount);

    /**
     * @return true if operation succeeded
     */
    public abstract boolean fund(BigDecimal amount);

    public abstract String getAccountName();

    /**
     * @return available amount, rounded down (@see {@link BigDecimal#ROUND_DOWN})
     */
    public BigDecimal getAvailableAmount() {
        return availableAmount.setScale(2, BigDecimal.ROUND_DOWN);
    }

    protected boolean isAmountAvailable(BigDecimal amount) {
        return availableAmount.compareTo(amount) >= 0;
    }

}
