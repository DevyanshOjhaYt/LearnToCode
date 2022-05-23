package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DepartmentServiceImpl;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) { // hibernate validaiton
		LOGGER.info("Inside saveDepartment");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		LOGGER.info("Inside fetchDepartment");
		return departmentService.getDepartmentList();
	}

	@GetMapping("/departments/{id}")
	public Department fetchById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
		return departmentService.getDepartmentById(id);
	}

	@DeleteMapping("/department/delete/{id}")
	public String deleteByid(@PathVariable("id") Long id) {
		departmentService.deleteDepartmentById(id);
		return "Record Deleted";
	}

	@PutMapping("/department/update/{id}")
	public Department updateById(@PathVariable("id") Long id, @RequestBody Department department) {
		return departmentService.updateDepartmentById(id, department);
	}

	@GetMapping("/department/{name}")
	public Department getByName(@PathVariable("name") String name) {
		return departmentService.getDepartmentByName(name);
	}

//	@GetMapping("/department/{name}")
//	public List<Department> getByNameAndCode(@PathVariable("dpName") String dpName,@PathVariable("dpCode") String dpCode)
//	{
//		return departmentService.getByNameAndCode(dpName,dpCode);
//	}

	@GetMapping("department/getStream/sameDepartmentDetails/{dname}")
	public List<Department> getSameDpDetails(@PathVariable("dname") String dname) {
		return departmentService.getSameDepartmentDetails(dname);
	}

}
