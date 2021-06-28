package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.GraduateService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Graduate;

@RestController
@RequestMapping("/api/graduate")
@CrossOrigin
public class GraduateController {
	
	private GraduateService graduateService;

	@Autowired
	public GraduateController(GraduateService graduateService) {
		super();
		this.graduateService = graduateService;
	}
	@GetMapping("/add")
	public Result add(Graduate graduate) {
		return this.graduateService.add(graduate);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Graduate>> getAll(){
		return this.graduateService.getAll();
	}
	@PostMapping("/update")
	public Result update(@RequestBody int graduateId, @RequestBody String description) {
		return this.graduateService.update(graduateId, description);
	}
	
}
