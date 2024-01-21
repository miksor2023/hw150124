package com.pro.sky.cours2.homework.hw150124;

import com.pro.sky.cours2.homework.hw150124.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestConstants {
    public static final Integer DEPARTMENT_1 = 1;
    public static final Integer DEPARTMENT_2 = 2;
    public static final Integer WRONG_DEPARTMENT = 6;
    public static final Double EMPLOYEE_1_SALARY = 10000D;
    public static final Double EMPLOYEE_3_SALARY = 12000D;
    public static final Double SALARY_SUM_IN_DEPT_1 = 33000D;
    public static final String EMPLOYEE_1_FIRSTNAME = "Ivan";
    public static final String EMPLOYEE_1_LASTNAME = "Ivanov";
    public static final String EXTRA_EMPLOYEE_FIRSTNAME = "Oleg";
    public static final String EXTRA_EMPLOYEE_LASTNAME = "Pukin";
    public static final Double EXTRA_EMPLOYEE_SALARY = 10000D;
    public static final Employee EMPLOYEE_1 = new Employee("Ivan", "Ivanov", 10000D, 1);
    public static final Employee EMPLOYEE_2 = new Employee("Ivan", "Sidorov", 11000D, 1);
    public static final Employee EMPLOYEE_3 = new Employee("Ivan", "Petrov", 12000D, 1);
    public static final Employee EMPLOYEE_4 = new Employee("Petr", "Vetrov", 20000D, 2);
    public static final Employee EMPLOYEE_5 = new Employee("Petr", "Ivanov", 21000D, 2);
    public static final Employee EMPLOYEE_6 = new Employee("Petr", "Shpetrov", 22000D, 2);
    public static final List<Employee> TEST_DEPT_1_EMPLOYEE_LIST = List.of(EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_3);
    public static final List<Employee> TEST_DEPT_2_EMPLOYEE_LIST = List.of(EMPLOYEE_4, EMPLOYEE_5, EMPLOYEE_6);


    public static final Map<String, Employee> TEST_EMPLOYEE_MAP = Map.of(
            "IvanIvanov", EMPLOYEE_1,
            "IvanSidorov", EMPLOYEE_2,
            "IvanPetrov", EMPLOYEE_3,
            "PetrVetrov", EMPLOYEE_4,
            "PetrIvanov", EMPLOYEE_5,
            "PetrShpetrov", EMPLOYEE_6);

    public static final Map<Integer, List<Employee>> TEST_EMPLOYEE_MAP_SORTED_BY_DEPTS = Map.of(
            DEPARTMENT_1, TEST_DEPT_1_EMPLOYEE_LIST,
            DEPARTMENT_2, TEST_DEPT_2_EMPLOYEE_LIST);

}
