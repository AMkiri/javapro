package skillbox.amkiri.module6.hw4.company;

import skillbox.amkiri.module6.hw4.Employee;

import java.util.*;

public class Company {

    private TreeSet<Employee> employees = new TreeSet<>(Comparator.comparingInt(Employee::getMonthSalary).reversed());

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        Iterator<Employee> iterator = employees.iterator();

        ArrayList<Employee> result = new ArrayList<>(5);
        for (int i = 0; i < count && iterator.hasNext(); i++) {
            result.add(iterator.next());
        }

        return result;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        Iterator<Employee> iterator = employees.descendingIterator();

        ArrayList<Employee> result = new ArrayList<>(5);
        for (int i = 0; i < count && iterator.hasNext(); i++) {
            result.add(iterator.next());
        }

        return result;
    }
}
