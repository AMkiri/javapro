package skillbox.amkiri.module5.hw2;

import skillbox.amkiri.module5.hw2.todolist.ToDoList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ToDoList toDoList = new ToDoList();

        System.out.println("Tape 'exit' to close the program.");
        System.out.println("Commands:\n" +
                "LIST,\n" +
                "ADD <position> <task>,\n" +
                "EDIT <position> <task>\n" +
                "DELETE <position>\n");

        while (true) {
            System.out.print(">>> ");
            String commandLine = reader.readLine().trim();

            if (commandLine.equalsIgnoreCase("exit")) {
                return;
            }

            String[] command = commandLine.split(" ");

            switch (command[0].toUpperCase()) {
                case "ADD":
                    if (command.length == 3) {
                        try {

                            int position = Integer.parseInt(command[1]) - 1;
                            toDoList.add(command[2], position);

                        } catch (Exception e) {

                            printWarn();

                        }
                    } else {
                        printWarn();
                    }
                    break;
                case "DELETE":
                    if (command.length == 2) {
                        try {

                            int position = Integer.parseInt(command[1]) - 1;
                            toDoList.delete(position);

                        } catch (Exception e) {

                            printWarn();

                        }
                    } else {
                        printWarn();
                    }
                    break;
                case "LIST":
                    List<String> todo = toDoList.list();

                    if (todo.isEmpty()) {
                        System.out.println("\nNothing to do.\n");
                        break;
                    }

                    System.out.println("\n\t---");
                    System.out.println("Things that I'll do someday: ");
                    int i = 1;
                    for (String task: todo) {
                        System.out.println("\t" + i +"\t-\t" + task);
                        i++;
                    }
                    System.out.println("\t---\n");
                    break;
                case "EDIT":
                    if (command.length == 3) {
                        try {

                            int position = Integer.parseInt(command[1]) - 1;
                            toDoList.edit(command[2], position);

                        } catch (Exception e) {

                            printWarn();

                        }
                    } else {
                        printWarn();
                    }
                    break;
                default:
                    printWarn();
            }
        }

    }

    private static void printWarn() {
        System.out.println("Can't recognize the command. Please, try again");
    }

}
