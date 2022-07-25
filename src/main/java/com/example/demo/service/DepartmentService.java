package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFound;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartments();

    public Department fetchDepartmentById(Long departmentid) throws DepartmentNotFound;

    public void deleteDepartmentById(Long departmentid);


    public Department updateDepartmentById(Long departmentid, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
