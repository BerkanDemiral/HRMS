package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.JobPositionService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/job_positions") // kodlama.io/api/products diye bir istekte bulunursak bu çalışacak.
public class JobPositionsController {
	private JobPositionService jobPositionsService;

	@Autowired // buisness-api iletişimi yapılması için
	// autoWired sayesinde proje taranıyor ve arkada new'leniyor.
	public JobPositionsController(JobPositionService jobPositionsService) {
		super();
		this.jobPositionsService = jobPositionsService;
	}
	@GetMapping("/getallJobPositions")
	public DataResult<List<JobPosition>> getAll() {
		return this.jobPositionsService.getAll();
	}

	@PostMapping("/addJobPosition") // bir şey gönderdiğimiz için -- post
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.jobPositionsService.add(jobPosition);
	}

}
