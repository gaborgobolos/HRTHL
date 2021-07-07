package hu.webuni.spring.hrtl.gg.model;

import java.time.LocalDate;

public class Employee {

    private Long id;
    private String name;
    private String jobposition;
    private int salary;
    private LocalDate workstart;
    
     public Employee(Long id, String name, String jobposition, int salary, LocalDate workstart) {
        this.id = id;
        this.name = name;
        this.jobposition = jobposition;
        this.salary = salary;
        this.workstart = workstart;
    }

     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobposition() {
        return jobposition;
    }

    public void setJobposition(String jobposition) {
        this.jobposition = jobposition;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getWorkstart() {
        return workstart;
    }

    public void setWorkstart(LocalDate workstart) {
        this.workstart = workstart;
    }
     
}
