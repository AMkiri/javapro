package skillbox.amkiri.module5.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;


public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CommandLine commandLine = new CommandLine();
        PhoneBook phoneBook = new PhoneBook();

        commandLine.printListOfCommands();

        while (true) {
            Command command = commandLine.getCommand(reader);

            switch (command.getType()) {
                case EXIT:

                    return;

                case LIST:

                    System.out.println(phoneBook);

                    break;

                case PHONE:

                    PhoneBook.Entry byPhoneNumEntry = phoneBook.findByPhoneNum(
                            PhoneNumUtils.format(command.getText())
                    );

                    if (byPhoneNumEntry.getName() != null) {

                        System.out.println(byPhoneNumEntry);

                    } else {

                        byPhoneNumEntry.setName(commandLine.getName(reader));
                        String result = phoneBook.addContact(byPhoneNumEntry);
                        System.out.println(result);

                    }

                    break;

                case NAME:

                    PhoneBook.Entry byNameEntry = phoneBook.findByName(
                            command.getText()
                    );

                    if (byNameEntry.getPhoneNum() != null) {

                        System.out.println(byNameEntry);

                    } else {

                        byNameEntry.setPhoneNum(commandLine.getPhoneNum(reader));
                        String result = phoneBook.addContact(byNameEntry);
                        System.out.println(result);

                    }

                    break;
            }

        }
    }

}
