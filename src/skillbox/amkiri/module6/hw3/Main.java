package skillbox.amkiri.module6.hw3;

import skillbox.amkiri.module6.hw3.clients.Client;
import skillbox.amkiri.module6.hw3.clients.Entrepreneur;
import skillbox.amkiri.module6.hw3.clients.Individual;
import skillbox.amkiri.module6.hw3.clients.Legal;

public class Main {

    public static void main(String[] args) {

        Client vasya = new Individual("Вася");
        Client buiseness = new Legal("ООО \"Рога и копыта\"");
        Client ip = new Entrepreneur("Пётр Иванович Блатных");

        System.out.println("Initial values");
        printAccAmounts(vasya, buiseness, ip);

        System.out.println("\n--- Fund 100 ---");
        vasya.fund(100);
        buiseness.fund(100);
        ip.fund(100);
        printAccAmounts(vasya, buiseness, ip);

        System.out.println("\n--- Fund 1000 ---");
        vasya.fund(1000);
        buiseness.fund(1000);
        ip.fund(1000);
        printAccAmounts(vasya, buiseness, ip);

        System.out.println("\n--- Withdrow 10 ---");
        vasya.withdrow(10);
        buiseness.withdrow(10);
        ip.withdrow(10);
        printAccAmounts(vasya, buiseness, ip);

    }

    private static void printAccAmounts(Client... clients) {
        System.out.println("\n\nAvailable money, rub");
        for (Client client:
                clients) {
            System.out.println(client.getDepositString());
        }
    }

}
