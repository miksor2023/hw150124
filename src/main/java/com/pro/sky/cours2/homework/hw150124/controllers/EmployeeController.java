package com.pro.sky.cours2.homework.hw150124.controllers;

import com.pro.sky.cours2.homework.hw150124.model.Employee;
import com.pro.sky.cours2.homework.hw150124.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    ;

    @GetMapping
    public String sayWelcome() {
        return "Добро пожаловать в книгу учёта сотрудников";
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam(name = "firstName", required = true) String firstName,
                                @RequestParam(name = "lastName", required = true) String lastName,
                                @RequestParam(name = "salary", required = true) Double salary,
                                @RequestParam(name = "department", required = true) Integer department) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam(name = "firstName", required = true) String firstName,
                                 @RequestParam(name = "lastName", required = true) String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam(name = "firstName", required = true) String firstName,
                                   @RequestParam(name = "lastName", required = true) String lastName) {

        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/print")
    public Collection<Employee> printEmployeeList() {
        return employeeService.returnAllEmployeeList();
    }



    //тестовый метод для заполнения списка записями
    @GetMapping("/load")
    public void loadEmployeeList() {
        employeeService.loadEmployeeList();
    }
}