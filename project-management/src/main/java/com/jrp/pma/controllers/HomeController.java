package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.IProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	IProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRep;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		//We are querying database for projects
		List<Project> projects=proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		//We are querying database for employees
		List<Employee> employees=empRep.findAll();
		model.addAttribute("employeesList", employees);
		
		return "main/home";
		
		
		
	}

}
