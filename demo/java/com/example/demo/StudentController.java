package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Student;

@Controller
public class StudentController {

  @Autowired
  StudentRepo repo;
	
  @GetMapping(path="students",produces={"application/xml"})
  @ResponseBody // used to return xml or json from jackson
  public List<Student> getStudents()
  {
	  List<Student> student=repo.findAll();
	  System.out.println("Returning Students from Repo");
	 // int i=9/0; afterReturning
	  return student;
  }
  
  @GetMapping("student/{sid}")
  @ResponseBody
  public Student getStudentById(@PathVariable("sid") int sid)
  {
	  Student student=repo.findById(sid).orElse(new Student(0,""));
	  return student;
  }
  
  @PostMapping(path="student",consumes = {"application/json"})
  @ResponseBody
  public Student setStudent(@RequestBody Student student)
  {
	  repo.save(student);
	  return student;
  }
}
