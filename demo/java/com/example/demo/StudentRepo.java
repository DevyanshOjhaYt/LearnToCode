package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	List<Student> getByName(String name);    //query DSL should start with findBy and
	                                         //next letter should be caps like N in Name

}
