package com.pro.sky.cours2.homework.hw150124.services;

import com.pro.sky.cours2.homework.hw150124.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private EmployeeService employeeService;


    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //метод возвращает список сотрудников по заданному отделу
    public List<Employee> getDepartmentEmployeeList(Integer department) {
            List<Employee> deptEmployees = employeeService.employeeMap.values().stream()
                    .filter(employee -> employee.getDepartment() == department)
                    .collect(Collectors.toList());
            return deptEmployees;
    }
    //метод возвращает список сотрудников, отсортированный по отделам
    public Map getEmployeeListByDepartment(){
        Map<Integer,List<Employee>> grouppedByDept = employeeService.employeeMap.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return grouppedByDept;
    }

    //метод "ищем минимальную зарплату по отделу"
    public Double getMinSalaryInDept(Integer department) {
        Double minSalary = getDepartmentEmployeeList(department).stream()
                .mapToDouble(emloyee -> emloyee.getSalary())
                .min()
                .getAsDouble();
        return minSalary;
    }

    //метод "ищем максимальную зарплату по отделу"
    public Double getMaxSalaryInDept(Integer department) {
        Double maxSalary = getDepartmentEmployeeList(department).stream()
                .mapToDouble(emloyee -> emloyee.getSalary())
                .max()
                .getAsDouble();
        return maxSalary;
    }

    //метод возвращает сумму зарпоат по заданному отделу
    public Double getDepartmentSalarySum(Integer department){
        Double departmentSalarySum = employeeService.employeeMap.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToDouble(emloyee -> emloyee.getSalary())
                .sum();
        return departmentSalarySum;

    }
}
