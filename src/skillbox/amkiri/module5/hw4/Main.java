package skillbox.amkiri.module5.hw4;

import javax.swing.text.MaskFormatter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Tape 'exit' to close the program.");
        System.out.println("Commands:\n" +
                "LIST,\n" +
                "<phone number>\n" +
                "<name>\n");

        MaskFormatter maskFormatter = new MaskFormatter("+# ### ###-##-##");
        maskFormatter.setValueContainsLiteralCharacters(false);

        Map<String, String> phoneBook = new TreeMap<>();

        while (true) {
            System.out.print(">>> ");
            String commandLine = reader.readLine().trim();

            switch (commandLine.toLowerCase()) {
                case "exit":
                    return;

                case "list":
                    if (phoneBook.isEmpty()) {
                        System.out.println("\nNo data.\n");
                        break;
                    }

                    System.out.println("\n\t---");
                    for (Map.Entry en : phoneBook.entrySet()) {
                        System.out.println(en.getKey() + "\t--->\t" + en.getValue());
                    }
                    System.out.println("\t---\n");

                    break;

                default:

                    if (isPhoneNumber(commandLine)) {

                        String phoneNum = maskFormatter
                                .valueToString(
                                        commandLine.replaceAll("[ +-]", "")
                                );

                        if (phoneBook.containsValue(phoneNum)) {
                            phoneBook.entrySet().stream()
                                    .filter(entry -> entry.getValue().equals(phoneNum))
                                    .findFirst()
                                    .ifPresent(
                                            en -> System.out.println(en.getKey() + "\t--->\t" + en.getValue())
                                    );

                        } else {
                            System.out.print("Enter contact's name: ");
                            String name = reader.readLine();
                            phoneBook.put(name, phoneNum);
                            System.out.println("New contact created.");
                        }

                    } else { //it's name

                        if (phoneBook.containsKey(commandLine)) {
                            String phoneNum = phoneBook.get(commandLine);
                            System.out.println(commandLine + "\t--->\t" + phoneNum);
                        } else {

                            String phoneStr;

                            do {
                                System.out.print("Enter contact's phone number: ");
                                phoneStr = reader.readLine();
                            } while (!isPhoneNumber(phoneStr));

                            String phoneNum = maskFormatter
                                    .valueToString(
                                            phoneStr.replaceAll("[ +-]", "")
                                    );
                            phoneBook.put(commandLine, phoneNum);
                            System.out.println("New contact created.");
                        }

                    }
            }

        }
    }

    // just russian
    private static boolean isPhoneNumber(String str) {
        return str
                .replaceAll("[ -()]", "")
                .matches("^((\\+7|7|8)+([0-9]){10})$");
    }
}
