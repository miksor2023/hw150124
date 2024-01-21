package com.pro.sky.cours2.homework.hw150124.services;

import com.pro.sky.cours2.homework.hw150124.exceptions.EmployeeAlreadyAddedException;
import com.pro.sky.cours2.homework.hw150124.exceptions.EmployeeNotFoundException;
import com.pro.sky.cours2.homework.hw150124.exceptions.EmployeeStorageIsFullException;
import com.pro.sky.cours2.homework.hw150124.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private Map<String, Employee> employeeMap = new HashMap<>();

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    private static int maxEmployeeQty = 10;
    //метод добавляет сотрудника

    public Employee addEmployee(String firstName, String lastName, double salary, int department) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName, salary, department);
        String key = firstName + lastName;
        if (employeeMap.size() < maxEmployeeQty && employeeMap.containsKey(key) == false) {
            employeeMap.put(key, employee);
            return employee;
        } else if (employeeMap.containsKey(key) == true) {
            throw new EmployeeAlreadyAddedException("Сотрудник с таким именем уже существует");
        } else {
            throw new EmployeeStorageIsFullException("Хранилище заполнено");
        }
    }
    //метод удаляет сотрудника по имени/фамилии

    public Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        String key = firstName + lastName;
        if (employeeMap.containsKey(key)) {
            Employee employee = employeeMap.get(key);
            employeeMap.remove(key);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
        }
    }
    //метод ищет сотрудника по имени/фамилии
    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        String key = firstName + lastName;
        if (employeeMap.containsKey(key)) {
            return employeeMap.get(key);
        } else {
            throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
        }
    }

    //тестовый метод возвращает коллекцию (set of values) мапы emoloyeeMap
    public Collection<Employee> returnAllEmployeeList() {
        return employeeMap.values();
    }
    //тестовый метод для заполнения списка записями
    public void loadEmployeeList() {
        addEmployee("Ivan", "Ivanov", 10000, 1);
        addEmployee("Ivan", "Sidorov", 11000, 1);
        addEmployee("Ivan", "Petrov", 12000, 1);
        addEmployee("Petr", "Vetrov", 20000, 2);
        addEmployee("Petr", "Shpetrov", 21000, 2);
        addEmployee("Petr", "Ivanov", 22000, 2);
        addEmployee("Vasiliy", "Sidorov", 30000, 3);
        addEmployee("Vasiliy", "Petrov", 31000, 3);
        addEmployee("Evgeniy", "Vetrov", 40000, 4);
        addEmployee("Evgeniy", "Shpetrov", 41000, 4);
    }
}
