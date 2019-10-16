package skillbox.amkiri.module6.hw4.company;

import skillbox.amkiri.module6.hw4.Employee;

public class Oparator implements Employee {

    private final String ID;

    private int salary;

    public Oparator(String ID, int salary) {
        this.ID = ID;
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public String printMonthSalary() {
        return String.format("%-10s: %10d", ID, getMonthSalary());
    }

}
