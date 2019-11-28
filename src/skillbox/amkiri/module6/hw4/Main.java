package skillbox.amkiri.module6.hw4;

import skillbox.amkiri.module6.hw4.company.Company;
import skillbox.amkiri.module6.hw4.company.Manager;
import skillbox.amkiri.module6.hw4.company.Operator;
import skillbox.amkiri.module6.hw4.company.TopManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        Company company = new Company(10000000);

        System.out.println("\n--- Check hire/fire one ---");
        Employee fake = new Operator("FAKE", 100000000, company);
        company.hire(fake);
        System.out.println("HIRE. Company contains fake: " + (company.getEmployees().contains(fake)));
        company.fire(fake);
        System.out.println("FIRE. Company contains fake: " + (company.getEmployees().contains(fake)));


        System.out.println("\n--- Hire 270 employees ---");
        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager("TM " + i, i * 1000, company));
        }

        for (int i = 0; i < 80; i++) {
            company.hire(new Manager("M " + i, i * 10, company));
        }

        Collection<Employee> operators = new ArrayList<>();
        for (int i = 0; i < 180; i++) {
            operators.add(new Operator("O " + i, i * 100, company));
        }
        company.hireAll(operators);

        testWorking(company);

        /// FIRE!!!
        System.out.println("\n--- Fire 10% (27) ---");
        company.fireAll(company.getLowestSalaryStaff(27));
        testWorking(company);

    }

    private static void testWorking(Company company) {
        System.out.println("Amount of employees: " + company.getEmployees().size());
        System.out.println("\n--- Work hard ---");
        company.closeNextMonth();
        System.out.println("Income: " + company.getIncome());
        printStaff(company, 10, 30);
    }

    private static void printStaff(Company company, int top, int low) {
        int amount = company.getEmployees().size();
        if (top + low > amount) {
            throw new IllegalArgumentException();
        }

        System.out.println("\n--- Salaries: ");

        int i = 1;

        for (Employee e:
                company.getTopSalaryStaff(top)) {
            System.out.println(i + ".\t\t" + e.printMonthSalary());
            i++;
        }

        System.out.println("\t...");

        i = amount - low + 1;
        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(low);
        Collections.reverse(lowestSalaryStaff);
        for (Employee e:
                lowestSalaryStaff) {
            System.out.println(i + ".\t\t" + e.printMonthSalary());
            i++;
        }
    }
}
