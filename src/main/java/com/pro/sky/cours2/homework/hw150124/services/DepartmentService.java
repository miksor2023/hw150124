package com.pro.sky.cours2.homework.hw150124.services;

import com.pro.sky.cours2.homework.hw150124.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private EmployeeService employeeService;


    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //метод возвращает список сотрудников по заданному отделу
    public Collection getDepartmentEmployeeList(Integer department) {
            List<Employee> deptEmployees = employeeService.employeeMap.values().stream()
                    .filter(employee -> employee.getDepartment() == department)
                    .collect(Collectors.toList());
            return deptEmployees;
    }
    //метод возвращает список сотрудников, отсортированный по отделам
    public Collection getEmployeeListByDepartments(){
        Set<Map.Entry<Integer,List<Employee>>> grouppedByDept = employeeService.employeeMap.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet();
        return grouppedByDept;
    }
    //метод возвращает мапу, в которой ключ - номер отдела, значение - список сотрудников отдела
    public Map<Integer, List<Employee>> groupByDept(){
        Map<Integer, List<Employee>> grouppedByDept = employeeService.employeeMap.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return grouppedByDept;
    }
    //метод "ищем сотрудника с минимальной зарплатой по отделу"
    public Employee getMinSalaryEmployeeInDept(Integer department) {
        Employee minSalaryEmployee = employeeService.employeeMap.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).get();
        return minSalaryEmployee;
    }
    //метод "ищем сотрудника с максимальной зарплатой по отделу"
    public Employee getMaxSalaryEmployeeInDept(Integer department) {
        Employee maxSalaryEmployee = employeeService.employeeMap.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).get();
        return maxSalaryEmployee;
    }
    //метод возвращает сумму зарпоат по заданному отделу
    public Double getDepartmentSalarySum(Integer id){
        Double departmentSalarySum = employeeService.employeeMap.values().stream()
                .
    }
}
