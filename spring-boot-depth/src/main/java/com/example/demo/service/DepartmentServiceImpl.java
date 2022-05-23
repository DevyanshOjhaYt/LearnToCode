package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.tool.schema.extract.spi.ExtractionContext.DatabaseObjectAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {

		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getDepartmentList() {
		// return departmentRepository.findAll();
		return departmentRepository.getAllDepartments();
	}

	@Override
	public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
		// return departmentRepository.findById(id).get();
		Optional<Department> department = departmentRepository.findById(id);
		if (!department.isPresent()) {
			throw new DepartmentNotFoundException("Departent Not Available");
		}
		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public Department updateDepartmentById(Long id, Department department) {
		Department dep = departmentRepository.findById(id).get();

		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
			dep.setDepartmentName(department.getDepartmentName());

		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
			dep.setDepartmentCode(department.getDepartmentCode());

		if (Objects.nonNull(department.getDepartmentAddress())
				&& !"".equalsIgnoreCase(department.getDepartmentAddress()))
			dep.setDepartmentAddress(department.getDepartmentAddress());

		return departmentRepository.save(dep);
	}

	@Override
	public Department getDepartmentByName(String name) {
		return departmentRepository.findByDepartmentNameIgnoreCase(name);
	}

	@Override
	public List<Department> getByNameAndCode(String dpName, String dpCode) {
		return departmentRepository.getSelectedDepartment(dpName, dpCode);
	}

	@Override
	public List<Department> getSameDepartmentDetails(String dname) {
		
		return departmentRepository.getAllDepartments()
				                   .stream()
				                   .filter(department->department.getDepartmentName().equalsIgnoreCase(dname))
				                   .collect(Collectors.toList());
	}

}
