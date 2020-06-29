package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.IProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping("/projects") 
public class ProjectController {
	
	@Autowired
	IProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRep;
	
	
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects= proRepo.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject=new Project();
		List<Employee> employees=empRep.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project,
			Model model) {
		
		//this should handle saving to the database....
		proRepo.save(project);
		return "redirect:/projects/new";
	}
	
	

}
