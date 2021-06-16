package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.JobExperienceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobExperience")
public class JobExperienceContoller {

	private JobExperienceService jobExperienceService;
	
	@Autowired
	public JobExperienceContoller(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
	@PostMapping("/sortOrderByEndetDate")
	public DataResult<List<JobExperience>> sortOrderByEndedDateDesc(@RequestParam int resumeId){
		return this.jobExperienceService.sortOrderByEndedDateDesc(resumeId);
	}

	
}
