package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.JobPostingService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.entities.concretes.Employer;
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
		this.jobPostingService.add(jobPosting);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

	@PostMapping("/update")
	public Result update(@RequestBody JobPosting jobPosting) {
		this.jobPostingService.update(jobPosting);
		return new SuccessResult("Güncelleme işlemi başarılı");
	}

	@GetMapping("/closeJobPosting")
	public Result closeJobPosting(JobPosting jobPosting, Employer employer) {
		this.jobPostingService.closeJobPosting(jobPosting, employer);
		return new SuccessResult("İş ilanı kapatıldı");
	}

	@GetMapping("/getByIsActive")
	public DataResult<List<JobPostingDto>> getByIsActive(boolean status) {
		return this.jobPostingService.getByIsActive(status);

	}
	
	@GetMapping("/orderByClosedDate")
	public DataResult<List<JobPosting>> getByIsActiveOrderByClosedDate(boolean status){
		return this.jobPostingService.getByIsActiveOrderByClosedDate(status);
	}
	@GetMapping("/getByEmployer")
	public DataResult<List<JobPostingDto>> getByIsActiveAndEmployer_CompanyName(boolean status,@Param("companyName") String companyName){
		return this.jobPostingService.getByIsActiveAndEmployer_CompanyName(status, companyName);
	}
}
