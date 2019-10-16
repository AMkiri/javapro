package skillbox.amkiri.module6.hw4.company;

import skillbox.amkiri.module6.hw4.Employee;

public class TopManager implements Employee {

    private final String ID;

    private int salary;
    private int bonusValue;
    private boolean isCompanyGoalReached;

    public TopManager(String ID, int salary, int bonusValue, boolean isCompanyGoalReached) {
        this.ID = ID;
        this.salary = salary;
        this.bonusValue = bonusValue;
        this.isCompanyGoalReached = isCompanyGoalReached;
    }

    private int getMonthBonus() {
        return isCompanyGoalReached ? bonusValue : 0;
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
