package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@RestController
@RequestMapping("/api/jobPosting")
@CrossOrigin
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


	@GetMapping("/getByIsActive")
	public DataResult<List<JobPosting>> getByIsActive(){
		return this.jobPostingService.getByIsActive();
	}

	
	@PostMapping("/getByEmployerEmployerId")
	public DataResult<List<JobPosting>> getByEmployer_Id(@RequestParam int id){
		return this.jobPostingService.getByEmployer_Id(id);
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<JobPosting>> getAllSorted(){
		return this.jobPostingService.getAllSorted();
	}
	
	@PostMapping("/changeStatus")
	public DataResult<JobPosting> changeStatus(@RequestParam int jobPostingId, @RequestParam boolean status,@RequestParam int employerId){
		return this.jobPostingService.changeStatus(jobPostingId, status, employerId);
	}
	
	@PostMapping("/getById")
	public DataResult<JobPosting> getById(@RequestParam int id){
		return this.jobPostingService.getById(id);
	}
	

}
