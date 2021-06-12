package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.JobPostingService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.entities.concretes.JobPosting;
import javacamp.hrms.entities.dtos.JobPostingDto;

@RestController
@RequestMapping("/api/jobPosting")
public class JobPostingController {
	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll() {
		return this.jobPostingService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {

		return this.jobPostingService.add(jobPosting);
	}

	@PostMapping("/update")
	public Result update(@RequestBody JobPosting jobPosting) {
		this.jobPostingService.update(jobPosting);
		return new SuccessResult("Güncelleme işlemi başarılı");
	}


	@GetMapping("/getAllIsActiveJobPostings")
	public DataResult<List<JobPostingDto>> getByIsActive(){
		return this.jobPostingService.getByIsActive();
	}

	
	@PostMapping("/getAllIsActiveJobPostingsByEmployer")
	public DataResult<List<JobPostingDto>> getByEmployer_EmployerId(@RequestParam int id){
		return this.jobPostingService.getByEmployer_EmployerId(id);
	}
	

}
