package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.EducationService;
import javacamp.hrms.core.utilities.results.DataResult;
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
	
	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		return this.educationService.add(education);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}
	@PostMapping("/sortOrderByEndetDate")
	public DataResult<List<Education>> sortOrderByEndedDateDesc(@RequestParam int resumeId){
		return this.educationService.sortOrderByEndedDateDesc(resumeId);
	}
}
