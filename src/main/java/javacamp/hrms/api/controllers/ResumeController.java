package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.buisness.abstracts.ResumeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

	private ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Resume resume) {
		return this.resumeService.add(resume);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Resume>> getAll(){
		return this.resumeService.getAll();
	}
	
	@PostMapping("/findAllByCandidate")
	public DataResult<List<Resume>> findAllByCandidate_Id(@RequestParam int id){
		return this.resumeService.findAllByCandidate_Id(id);
	}
	
	@PostMapping("/saveImage")
	public Result saveImage(@RequestBody MultipartFile file,@RequestParam int resumeId) {
		return this.resumeService.saveImage(file, resumeId);
	}
	
	@PostMapping("/updateAll")
	public Result update(@RequestParam int resumeId ,@RequestParam String linkedinLink,@RequestParam String githubLink) {
		return this.resumeService.update(resumeId, linkedinLink, githubLink);
	}
	
	@PostMapping("/updateLinkedin")
	public Result updateLinkedin(@RequestParam int resumeId ,@RequestParam String linkedinLink) {
		return this.resumeService.updateLinkedin(resumeId, linkedinLink);
	}
	
	@PostMapping("/updateGithub")
	public Result updateGithub(@RequestParam int resumeId , @RequestParam String githubLink) {
		return this.resumeService.updateGithub(resumeId, githubLink);
	}
	@PostMapping("/findById")
	public DataResult<Resume> findById(@RequestParam int id){
		return this.resumeService.findById(id);
	}
}
