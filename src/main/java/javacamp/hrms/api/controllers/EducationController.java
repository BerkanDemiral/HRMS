package javacamp.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.EducationService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/education")
public class EducationController {
	
	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/add")
	public Result add(Education education) {
		return this.educationService.add(education);
	}
	
}
