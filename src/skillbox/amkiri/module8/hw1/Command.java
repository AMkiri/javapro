package skillbox.amkiri.module8.hw1;

public class Command {

    private static final char COMMAND_END_CHAR = ' ';

    private static final String PHONE_REGEX = "^\\+7[0-9]{10}$";
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";

    private String action;
    private Customer data = null;


    private static final Command NO_COMMAND = new Command("no_action", null);

    /**
     * @return null when command is wrong
     */
    public static Command parse(String command) {
        if (command == null) {
            return NO_COMMAND;
        }

        command = command.trim();
        if (command.isEmpty()) {
            return NO_COMMAND;
        }

        int pos = command.indexOf(COMMAND_END_CHAR);

        String action = pos != -1 ?
                command.substring(0, pos)
                : command;

        Customer data = null;

        switch (action) {

            case "add":
            case "remove":
                if (pos <= -1) {
                    System.out.println("Invalid position in array");
                    return NO_COMMAND;
                }

                data = parseData(command.substring(pos + 1).trim());
                break;

            case "list":
            case "count":
            case "help":
                break;

            default:
                return NO_COMMAND;
        }

        return new Command(action, data);
    }

    /**
     * @param data format: "Name Surname e-mail +7XXXXXXXXXX"
     * @return
     */
    private static Customer parseData(String data) {

        String[] components = data.split("\\s+");

        if ( components.length == 2) {
            String name = components[0] + " " + components[1];
            return new Customer(name, "", "");

        } else {
            if (components.length != 4) {
                System.out.println("Invalid data format.\n");
                return null;
            }

            String errMsg = "";
            if (!isEmailCorrect(components[2])) {
                errMsg += "Incorrect e-mail.\n";
            }
            if (!isPhoneNumberCorrect(components[3])) {
                errMsg += "Incorrect phone number.\n";
            }
            if(!errMsg.isEmpty()) {
                System.out.println(errMsg);
                return null;
            }

            String name = components[0] + " " + components[1];
            return new Customer(name, components[3], components[2]);
        }
    }

    private Command(String action, Customer data) {
        this.action = action;
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public Customer getData() {
        return data;
    }

    private static boolean isPhoneNumberCorrect(String phone) {
        return phone != null
                && phone.matches(PHONE_REGEX);
    }

    private static boolean isEmailCorrect(String email) {
        return email != null
                && email.matches(EMAIL_REGEX);
    }
}
