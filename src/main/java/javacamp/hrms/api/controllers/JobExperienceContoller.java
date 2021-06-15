package javacamp.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.JobExperienceService;

@RestController
@RequestMapping("/api/jobExperience")
public class JobExperienceContoller {

	private JobExperienceService jobExperienceService;
	
	@Autowired
	public JobExperienceContoller(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	

	
}
