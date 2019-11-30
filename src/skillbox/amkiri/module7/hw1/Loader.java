package skillbox.amkiri.module7.hw1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    private static String staffFile = "src/skillbox/amkiri/module7/hw1/data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                LocalDate date = LocalDate.parse(fragments[2], formatter);
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        date
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }

}
