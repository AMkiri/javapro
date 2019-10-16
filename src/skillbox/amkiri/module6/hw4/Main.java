package skillbox.amkiri.module6.hw4;

import skillbox.amkiri.module6.hw4.company.Company;
import skillbox.amkiri.module6.hw4.company.Manager;
import skillbox.amkiri.module6.hw4.company.Oparator;
import skillbox.amkiri.module6.hw4.company.TopManager;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Company company = new Company();

        Employee fake = new Oparator("FAKE", 100000000);
        company.addEmployee(fake);
        company.deleteEmployee(fake);

        for (int i = 0; i < 20; i++) {
            company.addEmployee(new TopManager("TM " + i, i, i * 3, true));
        }

        for (int i = 0; i < 50; i++) {
            company.addEmployee(new Manager("M " + (i+20), i, i * 10));
        }

        for (int i = 0; i < 20; i++) {
            company.addEmployee(new Oparator("O " + (i + 70), i));
        }

        System.out.println("Salaries: ");
        for (Employee e:
             company.getTopSalaryStaff(5)) {
            System.out.println(e.printMonthSalary());
        }
        System.out.println("\t...");
        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(5);
        Collections.reverse(lowestSalaryStaff);
        for (Employee e:
                lowestSalaryStaff) {
            System.out.println(e.printMonthSalary());
        }
    }

}
