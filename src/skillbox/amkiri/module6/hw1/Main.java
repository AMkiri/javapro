package skillbox.amkiri.module6.hw1;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        DepositAcc deposit = new DepositAcc(BigDecimal.TEN);
        CardAcc card = new CardAcc(BigDecimal.TEN);

        System.out.println("Initial values");
        printAccAmounts(deposit, card);

        System.out.println("\n--- Withdrow 1.5 ---");
        System.out.println(deposit.getAccountName() + ": "+ deposit.withdrow(BigDecimal.valueOf(1.5)));
        System.out.println(card.getAccountName() + ": "+ card.withdrow(BigDecimal.valueOf(1.5)));
        printAccAmounts(deposit, card);

        System.out.println("\n--- Fund 0.5 ---");
        System.out.println(deposit.getAccountName() + ": "+ deposit.fund(BigDecimal.valueOf(0.5)));
        System.out.println(card.getAccountName() + ": "+ card.fund(BigDecimal.valueOf(0.5)));
        printAccAmounts(deposit, card);

        System.out.println("\n--- Withdrow 1 ---");
        System.out.println(deposit.getAccountName() + ": "+ deposit.withdrow(BigDecimal.valueOf(1)));
        System.out.println(card.getAccountName() + ": "+ card.withdrow(BigDecimal.valueOf(1)));
        printAccAmounts(deposit, card);
    }

    private static void printAccAmounts(Account... accounts) {
        System.out.println("Available money, rub");
        for (Account account:
             accounts) {
            System.out.println(account.getAccountName() + ":\t" + account.getAvailableAmount());
        }
    }

}
