package com.pro.sky.cours2.homework.hw150124;

import com.pro.sky.cours2.homework.hw150124.exceptions.InvalidDepartmentNumberException;
import com.pro.sky.cours2.homework.hw150124.services.DepartmentService;
import com.pro.sky.cours2.homework.hw150124.services.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static com.pro.sky.cours2.homework.hw150124.TestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    public EmployeeService employeeServiceMock;
    @InjectMocks
    private DepartmentService out;
    @Test
    public void mustReturnDepartmentLıst(){
        when(employeeServiceMock.getEmployeeMap()).thenReturn(TEST_EMPLOYEE_MAP);
        Assertions.assertEquals(TEST_DEPT_1_EMPLOYEE_LIST, out.getDepartmentEmployeeList(DEPARTMENT_1));
    }
    @Test
    public void mustReturnEmployeeListSortedByDepartment(){
        when(employeeServiceMock.getEmployeeMap()).thenReturn(TEST_EMPLOYEE_MAP);
        Assertions.assertEquals(TEST_EMPLOYEE_MAP_SORTED_BY_DEPTS, out.getEmployeeListSortedByDepartment());
    }
    @Test
    public void mustReturnMinSalaryInDepartment(){
        when(employeeServiceMock.getEmployeeMap()).thenReturn(TEST_EMPLOYEE_MAP);
        Assertions.assertEquals(EMPLOYEE_1_SALARY, out.getMinSalaryInDept(DEPARTMENT_1));
    }
    @Test
    public void mustReturnMaxSalaryInDepartment(){
        when(employeeServiceMock.getEmployeeMap()).thenReturn(TEST_EMPLOYEE_MAP);
        Assertions.assertEquals(EMPLOYEE_3_SALARY, out.getMaxSalaryInDept(DEPARTMENT_1));
    }
    @Test
    public void mustReturnSumOfSalariesInDepartment(){
        when(employeeServiceMock.getEmployeeMap()).thenReturn(TEST_EMPLOYEE_MAP);
        Assertions.assertEquals(SALARY_SUM_IN_DEPT_1, out.getDepartmentSalarySum(DEPARTMENT_1));
    }
    @Test
    public void mustTwrowInvalidDepartmentNumberEceptionWhenGettingDepartmentList(){
        when(employeeServiceMock.getEmployeeMap()).thenReturn(TEST_EMPLOYEE_MAP);
        assertThrows(InvalidDepartmentNumberException.class, () -> out.getDepartmentEmployeeList(WRONG_DEPARTMENT));
    }
    @Test
    public void mustTwrowInvalidDepartmentNumberEceptionWhenCalculatingMinSalary(){
        when(employeeServiceMock.getEmployeeMap()).thenReturn(TEST_EMPLOYEE_MAP);
        assertThrows(InvalidDepartmentNumberException.class, () -> out.getMinSalaryInDept(WRONG_DEPARTMENT));
    }
    @Test
    public void mustTwrowInvalidDepartmentNumberEceptionWhenCalculatingMaxSalary(){
        when(employeeServiceMock.getEmployeeMap()).thenReturn(TEST_EMPLOYEE_MAP);
        assertThrows(InvalidDepartmentNumberException.class, () -> out.getMaxSalaryInDept(WRONG_DEPARTMENT));
    }
    @Test
    public void mustTwrowInvalidDepartmentNumberEceptionWhenCalculatingSum(){
        when(employeeServiceMock.getEmployeeMap()).thenReturn(TEST_EMPLOYEE_MAP);
        assertThrows(InvalidDepartmentNumberException.class, () -> out.getDepartmentSalarySum(WRONG_DEPARTMENT));
    }
}
