package skillbox.amkiri.module5.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

class CommandLine {

    void printListOfCommands() {
        System.out.println("Tape 'exit' to close the program.");
        System.out.println("Commands:\n" +
                "LIST,\n" +
                "<phone number>\n" +
                "<name>\n");
    }

    Command getCommand(BufferedReader reader) throws IOException {

        System.out.print(">>> ");
        String commandLine = reader.readLine().trim();

        Command.CommandType type;

        if (commandLine.equalsIgnoreCase("exit")) {
            type = Command.CommandType.EXIT;

        } else if (commandLine.equalsIgnoreCase("list")) {
            type = Command.CommandType.LIST;

        } else if (PhoneNumUtils.isPhoneNumber(commandLine)) {
            type = Command.CommandType.PHONE;

        } else {
            type = Command.CommandType.NAME;

        }

        return new Command(type, commandLine);
    }

    String getPhoneNum(BufferedReader reader) throws IOException, ParseException {

        String phoneStr;

        do {
            System.out.print("Enter contact's phone number: ");
            phoneStr = reader.readLine();
        } while (!PhoneNumUtils.isPhoneNumber(phoneStr));

        return PhoneNumUtils.format(phoneStr);
    }

    String getName(BufferedReader reader) throws IOException {
        System.out.print("Enter contact's name: ");
        return reader.readLine();
    }



}
