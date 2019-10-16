package skillbox.amkiri.module6.hw4.company;

import skillbox.amkiri.module6.hw4.Employee;

public class Manager implements Employee {

    private final static double BONUS_PERCENT = 0.05;

    private final String ID;

    private int salary;
    private int monthProceeds;

    public Manager(String ID, int salary, int monthProceeds) {
        this.ID = ID;
        this.salary = salary;
        this.monthProceeds = monthProceeds;
    }

    private int getMonthBonus() {
        return (int)Math.round(monthProceeds * BONUS_PERCENT);
    }

    @Override
    public int getMonthSalary() {
        return salary + getMonthBonus();
    }

    @Override
    public String printMonthSalary() {
        return String.format("%-10s: %10d (salary: %d, bonus: %d)", ID, getMonthSalary(), salary, getMonthBonus());
    }

}
