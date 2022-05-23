package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> getDepartmentList();

	public Department getDepartmentById(Long id) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long id);

	public Department updateDepartmentById(Long id, Department department);

	public Department getDepartmentByName(String name);

	public List<Department> getByNameAndCode(String dpName, String dpCode);

	public List<Department> getSameDepartmentDetails(String dname);
}
