package skillbox.amkiri.module7.hw1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee
{
    private String name;
    private Integer salary;
    private LocalDate workStart;

    public Employee(String name, Integer salary, LocalDate workStart)
    {
        this.name = name;
        this.salary = salary;
        this.workStart = workStart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getWorkStart() {
        return workStart;
    }

    public void setWorkStart(LocalDate workStart) {
        this.workStart = workStart;
    }

    public String toString()
    {
        return String.format( "%-30s | %10d | %s",
                name,
                salary,
                (DateTimeFormatter.ofPattern("dd.MM.yyyy")).format(workStart)
        );
    }
}
