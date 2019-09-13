package skillbox.amkiri.module5.hw3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
 * Написать программу, в которой будет храниться перечень e-mail-ов.
 * E-mail’ы  можно добавлять через консоль командой ADD и печатать весь список командой LIST.
 * *Проверять корректность вводимых e-mail’ов и в случае необходимости печатать сообщение об ошибке.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Tape 'exit' to close the program.");
        System.out.println("Commands:\n" +
                "LIST,\n" +
                "ADD <e-mail>\n");

        Set<String> emails = new HashSet<>();

        while (true) {
            System.out.print(">>> ");
            String commandLine = reader.readLine().trim();

            if (commandLine.equalsIgnoreCase("exit")) {
                return;
            }

            String[] command = commandLine.split(" ");

            switch (command[0].toUpperCase()) {

                case "ADD":

                    if (command.length == 2 && check(command[1])) {
                        //check
                        emails.add(command[1]);
                    } else{
                        printWarn();
                    }
                    break;

                case "LIST":

                    if (emails.isEmpty()) {
                        System.out.println("\nNo data.\n");
                        break;
                    }

                    System.out.println("\n\t---");
                    for (String em : emails) {
                        System.out.println(em);
                    }
                    System.out.println("\t---\n");
                    break;

                default:
                    printWarn();
            }
        }
    }

    private static void printWarn() {
        System.out.println("Can't recognize the command. Please, try again");
    }

    // Java email validation permitted by RFC 5322
    private static boolean check(String email) {
        return email.toUpperCase().matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }
}
