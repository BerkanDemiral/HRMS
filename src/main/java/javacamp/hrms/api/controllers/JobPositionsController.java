package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.JobPositionsService;
import javacamp.hrms.entities.concretes.JobPositions;

@RestController
@RequestMapping("/api/job_positions") // kodlama.io/api/products diye bir istekte bulunursak bu çalışacak.
public class JobPositionsController {
	private JobPositionsService jobPositionsService;

	@Autowired // buisness-api iletişimi yapılması için
	// autoWired sayesinde proje taranıyor ve arkada new'leniyor.
	public JobPositionsController(JobPositionsService jobPositionsService) {
		super();
		this.jobPositionsService = jobPositionsService;
	}

	@GetMapping("/getall")
	public List<JobPositions> getAll() {
		return this.jobPositionsService.getAll();
	}

}
