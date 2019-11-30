package skillbox.amkiri.module7.hw1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import static skillbox.amkiri.module7.hw1.Loader.loadStaffFromFile;

public class Main
{


    public static void main(String[] args)
    {
        ArrayList<Employee> staff = loadStaffFromFile();

        // top payment first

        // by standard comparator
//        staff.sort(Comparator
//                .comparingInt(Employee::getSalary)
//                .reversed()
//                .thenComparing(Employee::getName)
//        );

        // by lambda
        staff.sort((e1,e2) -> {
            int diff = e2.getSalary() - e1.getSalary();
            if (diff == 0) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return diff;
            }
        });

        for (Employee e :
                staff) {
            System.out.println(e);
        }
    }
}