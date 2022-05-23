package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Student;

@Controller
public class HomeController {

	@Autowired
	StudentRepo repo;
	
	@ModelAttribute
	public void modeData(Model m)
	{
		m.addAttribute("name","Students To The Class");
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	@RequestMapping("add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,ModelMap m)
	{
		//we can also use model
		//ModelAndView mv=new ModelAndView();
		//mv.setViewName("result");
		//int num3=i+j;
		//mv.addObject("num3",num3);
		
		int num3=i+j;
		m.addAttribute("num3", num3);
		return "result";
	}
	
//	@RequestMapping("addStud")
//	public String addStud(@ModelAttribute("a") Student stud)
//	{
//	    return "result";	
//	}
	
//	@RequestMapping("addStud")
//	public String addStud(@ModelAttribute Student stud)
//	{
//	    return "result";	
//	}
	
//	@RequestMapping(value="addStud",method=RequestMethod.POST)
//	public String addStud(@ModelAttribute Student stud)
//	{
//	    return "result";	
//	}
	
//	@PostMapping(value = "addStud")
//	public String addStud(@ModelAttribute Student s)
//	{
//		return "result";
//	}
	
//	@GetMapping(value="getStud")
//	public String getStud(Model m)
//	{
//		List<Student> student=Arrays.asList(new Student(1,"Dev"),new Student(2,"Ayush"));
//		m.addAttribute("getStudResult", student);
//		return "RetrieveStud";
//	}
	
	@GetMapping(value="getStud")
	public String getStud(Model m)
	{
		m.addAttribute("getStudResult", repo.findAll());
		return "RetrieveStud";
	}
	@GetMapping(value="getStudById")
	public String getStudById(@RequestParam int id,Model m)
	{
		m.addAttribute("getStud", repo.getById(id));
		return "RetrieveStud";
	}
	
	@PostMapping(value = "addStud")
	public String addStud(@ModelAttribute Student s)
	{
		repo.save(s);
		return "result";
	}
	
	@GetMapping(value = "getStudByName")
	public String getStudByName(@RequestParam String name,Model m)
	{
		m.addAttribute("getStud",repo.getByName(name));
		return "RetrieveStud";
	}
	
}
