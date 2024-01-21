package com.pro.sky.cours2.homework.hw150124.model;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    private Double salary;
    private final Integer department;


    public Employee(String firatName, String lastName, Double salary, Integer department) {
        this.firstName = firatName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getSalary() {
        return salary;
    }
    public Integer getDepartment() {
        return department;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "имя: " + firstName +
                ", фамилия: " + lastName +
                ", зарплата: " + salary +
                ", отдел: " + department + "<br />";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }
}