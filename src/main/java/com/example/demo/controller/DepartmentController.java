package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFound;
import com.example.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department)
    {
        LOGGER.info("Inside saveDepartment og DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> getDepartments()
    {
        LOGGER.info("Inside getDepartments og DepartmentController");
        return departmentService.fetchDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentbyID(@PathVariable("id") Long departmentid) throws DepartmentNotFound {
        return departmentService.fetchDepartmentById(departmentid);
    }

    @PostMapping("/departments/{id}")
    public String deleteDepartmentbyID(@PathVariable("id") Long departmentid)
    {
        departmentService.deleteDepartmentById(departmentid);
        return "Department Deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentByID(@PathVariable("id") Long departmentid, @RequestBody Department department)
    {
        return departmentService.updateDepartmentById(departmentid,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName)
    {
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
