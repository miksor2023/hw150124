package com.pro.sky.cours2.homework.hw150124.controllers;

import com.pro.sky.cours2.homework.hw150124.model.Employee;
import com.pro.sky.cours2.homework.hw150124.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public String sayWelcome() {
        return "Операции по отделам";
    }



    @GetMapping("/{id}/employees")
    public Collection getDepartmentEmployeeList(@PathVariable Integer id){
        return departmentService.getDepartmentEmployeeList(id);
    }
    @GetMapping("/employees")
    public Collection getEmployeeListByDepartments(){
        return departmentService.getEmployeeListByDepartments();
    }

    @GetMapping("/{id}/salary/sum")
    public Double getDepartmentSalarySum(@PathVariable Integer id){
        return departmentService.getDepartmentSalarySum(id);
    }

//    @GetMapping("/min-salary")
//    public Employee getMinSalaryEmployeeInDept(@RequestParam(value = "departmentId", required = true) Integer department) {
//        return departmentService.getMinSalaryEmployeeInDept(department);
//    }
//    @GetMapping("/max-salary")
//    public Employee getMaxSalaryEmployeeInDept(@RequestParam(value = "departmentId", required = true) Integer department) {
//        return departmentService.getMaxSalaryEmployeeInDept(department);
//    }

}