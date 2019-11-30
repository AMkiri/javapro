package skillbox.amkiri.module6.hw4.company;

import skillbox.amkiri.module6.hw4.Employee;

public class TopManager extends Employee {

    public TopManager(String ID, int salary, Company company) {
        super(ID, salary, company);
    }

    @Override
    public int getMonthSalary() {
        return salary + bonusValue;
    }

    @Override
    public void countBonus() {
        bonusValue = company.isCompanyGoalAchieved() ? (int)Math.round(salary * 1.5) : 0;
    }
}
