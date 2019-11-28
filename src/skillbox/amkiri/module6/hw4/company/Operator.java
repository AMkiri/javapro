package skillbox.amkiri.module6.hw4.company;

import skillbox.amkiri.module6.hw4.Employee;

public class Operator extends Employee {

    public Operator(String ID, int salary, Company company) {
        super(ID, salary, company);
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public String printMonthSalary() {
        return String.format("%-10s: %10d", getName(), getMonthSalary());
    }

}
