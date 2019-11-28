package skillbox.amkiri.module6.hw4.company;

import skillbox.amkiri.module6.hw4.Employee;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Company {

    private final int COMPANY_GOAL;

    private List<Employee> employees = new LinkedList<>();

    private TreeSet<Employee> rangedEmployees = new TreeSet<>(Comparator.comparingInt(Employee::getMonthSalary).reversed().thenComparing(Employee::getName));
    private int monthIncome = 0;

    public Company(int company_goal) {
        COMPANY_GOAL = company_goal;
    }

    public void hire(Employee employee) {
        this.employees.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void fire(Employee employee) {
        this.employees.remove(employee);
    }

    public void fireAll() {
        this.employees.clear();
    }

    public void fireAll(Collection<Employee> employees) {
        this.employees.removeAll(employees);
    }

    public void closeNextMonth() {

        AtomicInteger gainedMoney = new AtomicInteger(0);
        employees.forEach(e -> gainedMoney.addAndGet(e.gainMoney()));
        monthIncome = gainedMoney.get();

        employees.forEach(Employee::countBonus);

        rangedEmployees.clear();
        rangedEmployees.addAll(employees);
    }

    public Integer getIncome() {
        return monthIncome;
    }

    public boolean isCompanyGoalAchieved() {
        return monthIncome >= COMPANY_GOAL;
    }

    public Collection<Employee> getEmployees() { return employees; }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        return getStaffBySalary(rangedEmployees.iterator(), count);
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        return getStaffBySalary(rangedEmployees.descendingIterator(), count);
    }

    private ArrayList<Employee> getStaffBySalary(Iterator<Employee> iterator, int count) {
        if (count > rangedEmployees.size()) return new ArrayList<>(rangedEmployees);

        ArrayList<Employee> result = new ArrayList<>(5);
        for (int i = 0; i < count && iterator.hasNext(); i++) {
            result.add(iterator.next());
        }

        return result;
    }
}
