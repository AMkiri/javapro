package skillbox.amkiri.module8.hw1;

import java.util.Scanner;

public class Main
{
    private static String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        System.out.println("\n--- Print <help> to see hint. ---\n");

        while (true) {
            try {
                Command command = Command.parse(scanner.nextLine());

                switch (command.getAction()) {
                    case "add":
                        executor.addCustomer(command.getData());
                        break;

                    case "list":
                        executor.listCustomers();
                        break;

                    case "remove":
                        executor.removeCustomer(command.getData().getName());
                        break;

                    case "count":
                        System.out.println("There are " + executor.getCount() + " customers");
                        break;

                    case "help":
                        System.out.println(helpText);
                        break;

                    case "exit" :
                        return;

                    default:
                        System.out.println(commandError);

                }
            } catch (IllegalArgumentException e) {

                String msg = e.getMessage();
                if (msg != null && !msg.isEmpty()) {
                    System.out.println("\n" + e.getMessage() + "\n");
                } else {
                    System.out.println(commandError);
                }

            }

        }
    }

}
