package skillbox.amkiri.module8.hw1;

public class Command {

    private static final char COMMAND_END_CHAR = ' ';

    private static final String PHONE_REGEX = "^\\+7[0-9]{10}$";
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";

    private String action;
    private Customer data = null;

    public static Command parse(String command) {
        if (command == null) {
            throw new IllegalArgumentException();
        }

        command = command.trim();
        if (command.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int pos = command.indexOf(COMMAND_END_CHAR);

        String action = pos != -1 ?
                command.substring(0, pos)
                : command;

        Customer data = null;

        switch (action) {

            case "add":
            case "remove":
                if (pos == -1) {
                    throw new IllegalArgumentException();
                }

                data = parseData(command.substring(pos + 1).trim());
                break;

            case "list":
            case "count":
            case "help":
                break;

            default:
                throw new IllegalArgumentException();
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

        } else if ( components.length != 4
                    || !isEmailCorrect(components[2])
                    || !isPhoneNumberCorrect(components[3])
        ) {

            throw new IllegalArgumentException("Incorrect data format.");

        }

        String name = components[0] + " " + components[1];
        return new Customer(name, components[3], components[2]);
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
