package com.pro.sky.cours2.homework.hw150124;

import com.pro.sky.cours2.homework.hw150124.exceptions.EmployeeAlreadyAddedException;
import com.pro.sky.cours2.homework.hw150124.exceptions.EmployeeNotFoundException;
import com.pro.sky.cours2.homework.hw150124.exceptions.EmployeeStorageIsFullException;
import com.pro.sky.cours2.homework.hw150124.services.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.pro.sky.cours2.homework.hw150124.TestConstants.*;

public class EmployeeServiceTest {
    private EmployeeService out = new EmployeeService();
    @Test
    public void mustAddAndReturnEmployee(){
        Assertions.assertEquals(EMPLOYEE_1, out.addEmployee(EMPLOYEE_1_FIRSTNAME, EMPLOYEE_1_LASTNAME, EMPLOYEE_1_SALARY, DEPARTMENT_1));
    }
    @Test
    public void mustFindAndReturnEmployee(){
        out.addEmployee(EMPLOYEE_1_FIRSTNAME, EMPLOYEE_1_LASTNAME, EMPLOYEE_1_SALARY, DEPARTMENT_1);//чтобы найти сотрудника, надо было его добавить
        Assertions.assertEquals(EMPLOYEE_1, out.findEmployee(EMPLOYEE_1_FIRSTNAME, EMPLOYEE_1_LASTNAME));
    }
    @Test
    public void mustRemoveEmployee(){
        out.addEmployee(EMPLOYEE_1_FIRSTNAME, EMPLOYEE_1_LASTNAME, EMPLOYEE_1_SALARY, DEPARTMENT_1);
        Assertions.assertEquals(EMPLOYEE_1, out.removeEmployee(EMPLOYEE_1_FIRSTNAME, EMPLOYEE_1_LASTNAME));
    }
    @Test
    public void mustThrowEmployeeAlreadyAddedException(){
        out.addEmployee(EMPLOYEE_1_FIRSTNAME, EMPLOYEE_1_LASTNAME, EMPLOYEE_1_SALARY, DEPARTMENT_1);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(EMPLOYEE_1_FIRSTNAME, EMPLOYEE_1_LASTNAME, EMPLOYEE_1_SALARY, DEPARTMENT_1));
    }
    @Test
    public void mustThrowEmployeeStorageIsFullException(){
        out.loadEmployeeList();//заполняем хранилище
        Assertions.assertThrows(EmployeeStorageIsFullException.class,
                () -> out.addEmployee(EXTRA_EMPLOYEE_FIRSTNAME, EXTRA_EMPLOYEE_LASTNAME, EXTRA_EMPLOYEE_SALARY, DEPARTMENT_1));
    }
    @Test
    public void mustThrowEmployeeNotFoundExceptionWhenFinding(){
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee(EMPLOYEE_1_FIRSTNAME, EMPLOYEE_1_LASTNAME));
    }
    @Test
    public void mustThrowEmployeeNotFoundExceptionWhenRemoving(){
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee(EMPLOYEE_1_FIRSTNAME, EMPLOYEE_1_LASTNAME));
    }

}
