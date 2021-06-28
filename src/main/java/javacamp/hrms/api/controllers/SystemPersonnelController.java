package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.SystemPersonnelService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/systemPersonnel")
@CrossOrigin
public class SystemPersonnelController {
	
	@Autowired
	private SystemPersonnelService systemPersonnelService;

	public SystemPersonnelController(SystemPersonnelService systemPersonnelService) {
		super();
		this.systemPersonnelService = systemPersonnelService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SystemPersonnel>> getAll(){
		return this.systemPersonnelService.getAll();
	}
	
	@PostMapping("/add")
	public Result verifySystemPersonnel(SystemPersonnel systemPersonnel) {
		return this.systemPersonnelService.verifySystemPersonnel(systemPersonnel);
	}
}
