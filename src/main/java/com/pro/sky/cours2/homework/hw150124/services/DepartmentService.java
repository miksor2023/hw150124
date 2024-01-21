package com.pro.sky.cours2.homework.hw150124.services;

import com.pro.sky.cours2.homework.hw150124.exceptions.InvalidDepartmentNumberException;
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
    public List<Employee> getDepartmentEmployeeList(Integer department) throws InvalidDepartmentNumberException {
        if(employeeService.getEmployeeMap().values().stream().//проверка на корректный номер отдела
                map(employee -> employee.getDepartment()).
                collect(Collectors.toList()).contains(department)) {
            List<Employee> deptEmployees = employeeService.getEmployeeMap().values().stream()
                    .filter(employee -> employee.getDepartment() == department)
                    .sorted((e1, e2) -> e1.getSalary().compareTo(e2.getSalary()))
                    .collect(Collectors.toList());
            return deptEmployees;
        } else {
            throw new InvalidDepartmentNumberException("ОШИБКА: Отдела с таким номером не существует");
        }
    }
    //метод возвращает список сотрудников, отсортированный по отделам
    public Map getEmployeeListSortedByDepartment(){
        Map<Integer,List<Employee>> grouppedByDept = employeeService.getEmployeeMap().values().stream()
                .sorted((e1, e2) -> e1.getSalary().compareTo(e2.getSalary()))
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
        Double departmentSalarySum = getDepartmentEmployeeList(department).stream()
                .mapToDouble(emloyee -> emloyee.getSalary())
                .sum();
        return departmentSalarySum;
    }
}
