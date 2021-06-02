package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.CandidateService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidate") 
public class CandidateController {
	private CandidateService candidateService;
	
	
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}


	@GetMapping("/getallCandidate") 
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	} 
	
	@PostMapping("/addCandidate") // bir şey gönderdiğimiz için -- post
	public Result add(@RequestBody Candidate candidate) { 
		return this.candidateService.add(candidate);
	}
}
