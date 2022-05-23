package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentName(String name);

	Department findByDepartmentNameIgnoreCase(String name);

	@Query("Select x from Department x")
	public List<Department> getAllDepartments();

	@Query("Select x from Department x where x.departmentName=:i and x.departmentCode=:j")
	public List<Department> getSelectedDepartment(@Param("i") String dpName, @Param("j") String dpCode);

}
